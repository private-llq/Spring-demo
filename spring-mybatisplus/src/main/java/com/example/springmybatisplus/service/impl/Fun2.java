package com.example.springmybatisplus.service.impl;

import java.util.Arrays;

public class Fun2 {
    public static void main(String[] args) {
        double [][]a={{1,1,-1},{2,1,0},{1,-1,0}};
        double [][]x=inverse(a);
        inversede(x);
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a[0].length;j++){
                inverse(a);
            }
        }
        System.out.println(Arrays.deepToString(inverse(a)));
    }

    private static void inversede(double[][] x) {

    }

    public static double[][] inverse(double[][] a) {
        // 输入矩阵a的行数和列数
        int n = a.length;
        int m = a[0].length;

        // 如果矩阵不是方阵，则无法求逆矩阵，返回null
        if (n != m) {
            return null;
        }

        // 构造增广矩阵[a|I]
        double[][] aug = new double[n][2*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aug[i][j] = a[i][j];
            }
            aug[i][i+n] = 1;
        }

        // 消元过程
        for (int i = 0; i < n; i++) {
            // 如果第i行第i列元素为0，则无法进行消元，返回null
            if (aug[i][i] == 0) {
                return null;
            }

            // 将第i行第i列元素变为1，同时将第i行其他元素变为0
            double k = 1 / aug[i][i];
            for (int j = 0; j < 2*n; j++) {
                aug[i][j] *= k;
            }
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    k = -aug[j][i];
                    for (int l = 0; l < 2*n; l++) {
                        aug[j][l] += k * aug[i][l];
                    }
                }
            }
        }

        // 返回结果，即[a|A^-1]的右半部分A^-1
        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = aug[i][j+n];
            }
        }
        return inv;
    }
}