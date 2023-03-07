package org.example.collection;

/**
 * @author weige
 * 归并排序
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = new int[8000000];
        for (int i = 0; i < ints.length; i++) {
            int i1 = (int) (Math.random() * 8000000);
            ints[i] = i1;
        }
        long l = System.currentTimeMillis();
        mergeSorting(ints,0,ints.length - 1);
        System.out.println("归并排序" + (System.currentTimeMillis() - l));
    }

    /**
     * 归并排序
     * 将数组分成n份，分别对n份进行排序，再合并在一起
     */
    public static void mergeSorting(int[] ints,int l,int r){
        if (l == r){
            return;
        }
        // 中间的数
        int mind = l + ((r - l) >> 1);
        // 递归
        mergeSorting(ints,l,mind);
        mergeSorting(ints,mind + 1,r);
        // 进行合并
        merge(ints,l,mind,r);

    }

    /**
     * 进来的 l - mind，mind - r分别都是有序的，将两个有序的数组拷贝到一个新数组中，最后将新数组中的值设置到原数组对应的位置
     * @param ints
     * @param l
     * @param mind
     * @param r
     */
    private static void merge(int[] ints, int l, int mind, int r) {
        int[] help = new int[r - l + 1];
        int i  = 0;
        // 两边开始的下标
        int p1 = l;
        int p2 = mind + 1;

        // 合并两个数组 -》 依次将两边数组的值拿来比较，按照规则添加到辅助数组中
        while (p1 < mind && p2 < r){
            help[i++] = ints[p1] <= ints[p2] ? ints[p1 ++] : ints[p2++];
        }
        // 当任意一边的数组合并完成以后，将另一边的数组添加到后面
        while (p1 <= mind){
            help[i++] = ints[p1++];
        }
        while (p2 <= r){
            help[i++] = ints[p2++];
        }

        // 将新数组的值设置到原数组中
        for (int i1 = 0; i1 < help.length; i1++) {
            ints[l + i1] = help[i1];
        }
    }

}
