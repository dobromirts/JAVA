package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rowsAndCols = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = nums[col];
            }
        }

        int bestSum = Integer.MIN_VALUE;
        String firstLine="";
        String secondLine="";
        String thirdLine="";


        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    firstLine=matrix[i][j]+" " + matrix[i][j + 1]+" " + matrix[i][j + 2];
                    secondLine= matrix[i + 1][j]+" " + matrix[i + 1][j + 1]+" " + matrix[i + 1][j + 2];
                    thirdLine=matrix[i + 2][j]+ " " + matrix[i + 2][j + 1]+ " " + matrix[i + 2][j + 2];

                }


            }

        }

        System.out.println("Sum = "+bestSum);
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
    }
}

