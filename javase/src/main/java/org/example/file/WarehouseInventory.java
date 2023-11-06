package org.example.file;

import java.util.PriorityQueue;

public class WarehouseInventory {
    public static void main(String[] args) {
        // 初始化仓库布局和盘点用时权重
        int rows = 6;
        int cols = 6;
        int[][] inventoryWeights = {
            {3, 4, 2, 6, 1, 2},
            {5, 2, 4, 3, 1, 5},
            {2, 1, 3, 4, 2, 3},
            {4, 2, 1, 5, 3, 2},
            {2, 3, 4, 1, 2, 4},
            {1, 2, 3, 5, 6, 3}
        };

        // 使用Dijkstra算法找到最短路径
        int[][] shortestPath = findShortestPath(inventoryWeights);

        // 打印最短路径
        printShortestPath(shortestPath, rows, cols);
    }

    private static int[][] findShortestPath(int[][] weights) {
        int rows = weights.length;
        int cols = weights[0].length;

        int[][] shortestPath = new int[rows][cols];
        int[][] minDistances = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        // 初始化最短路径和最小距离
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                shortestPath[i][j] = -1;
                minDistances[i][j] = Integer.MAX_VALUE;
            }
        }

        // 使用优先队列来进行Dijkstra算法
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, weights[0][0]));
        minDistances[0][0] = weights[0][0];

        // 定义可能的移动方向（上、下、左、右）
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            // 尝试向四个方向移动
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    int newDistance = minDistances[x][y] + weights[newX][newY];

                    if (newDistance < minDistances[newX][newY]) {
                        minDistances[newX][newY] = newDistance;
                        shortestPath[newX][newY] = x * cols + y;
                        queue.offer(new Node(newX, newY, newDistance));
                    }
                }
            }
        }
        return shortestPath;
    }

    private static void printShortestPath(int[][] shortestPath, int rows, int cols) {
        int x = rows - 1;
        int y = cols - 1;
        int index = x * cols + y;

        while (index != -1) {
            System.out.print("[" + x + "," + y + "] -> ");
            int prevX = index / cols;
            int prevY = index % cols;
            index = shortestPath[prevX][prevY];
            x = prevX;
            y = prevY;
        }

        System.out.println("[" + 0 + "," + 0 + "]");
    }

    static class Node implements Comparable<Node> {
        int x, y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}