package com.nonstriater.deepinjava.algo.matrix;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 顺时针打印矩阵
 * 难点： 各种边界条件判断，很容易搞错
 */
public class PrintMatrix {

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        printMatrix(matrix, 5, 3);

        System.out.println();

        int[][] matrix2 = {
                {1,2,3,4,5,6},
                {6,7,8,9,10,11},
                {11,12,13,14,15,16},
                {17,18,19,20,21,22}
        };
        printMatrix(matrix2, 6, 4);
    }

    /**
     * 打印矩阵
     * @param matrix
     * @param cols
     * @param rows
     */
    public static void printMatrix(int[][] matrix, int cols, int rows){
        if (matrix == null) {
            return;
        }
        if (cols < 0 || rows < 0) {
            return;
        }

        int start = 0;
        while (start*2 < cols && start*2 < rows) {
            doPrintMatrix(matrix, cols, rows, start);
            start++;
        }
    }

    /**
     * 打印第n圈, n 从 0 开始
     * @param matrix
     * @param cols
     * @param rows
     * @param start 第几圈
     */
    public static void doPrintMatrix(int[][] matrix, int cols, int rows, int start){

        int endX = cols -  start -1;
        int endY = rows -  start -1;

        //上
        for (int i = start; i <= endX ; i++) {
            System.out.printf("%d " , matrix[start][i]);
        }

        //右
        for (int i = start+1; i <= endY ; i++) {
            System.out.printf("%d " , matrix[i][endX]);
        }

        //下
        for (int i = endX-1; i >= start ; i--) {
            System.out.printf("%d " , matrix[endY][i]);
        }

        //左
        for (int i = endY-1; i > start ; i--) {
            System.out.printf("%d " , matrix[i][start]);
        }
    }

}
