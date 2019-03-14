package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]rowsAndCols=reader.readLine().split(", ");
        int n=Integer.parseInt(rowsAndCols[0]);
        String pattern=rowsAndCols[1];
        int[][]matrix=new int[n][n];

        if (pattern.equals("A")){
            matrix=fillMatrixA(matrix,n,n);
        }else{
            matrix=fillMatrixB(matrix,n,n);
        }

        printMatrix(matrix,n);




    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixB(int[][] matrix, int rows, int cols) {
        int value=1;
        for (int col = 0; col <matrix.length ; col++) {
            if (col%2==0){
                for (int row = 0; row <matrix.length  ; row++) {
                    matrix[row][col]=value++;
                }
            }else {
                for (int row = matrix.length-1; row >=0 ; row--) {
                    matrix[row][col]=value++;
                }
            }

        }
        return matrix;
    }

    private static int[][] fillMatrixA(int[][] matrix, int rows, int cols) {
        int value=0;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[j][i]=++value;
            }
        }

        return matrix;
    }
}
