package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }

        int primaryDiagonal = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) {
                    primaryDiagonal += matrix[row][col];
                }
            }
        }
        int secondaryDiagonal = 0;

        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                if (row + col == n-1) {
                    secondaryDiagonal += matrix[row][col];
                }

            }
        }
        System.out.println();

        int result = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(result);
    }
}
