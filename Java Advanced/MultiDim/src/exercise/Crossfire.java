package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rowsAndCols = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        int startingNum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                startingNum++;
                matrix[row][col] = startingNum;
            }

        }
        boolean aditionalColonIsValid = true;
        boolean subColonIsValid = true;
        boolean subRowIsValid = true;
        boolean aditionalRowisValid = false;

        String command = reader.readLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] coordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowInMatrix = coordinates[0];
            int colInMatrix = coordinates[1];
            int radius = coordinates[2];

            matrix[rowInMatrix][colInMatrix] = 0;


            for (int i = 1; i <= radius; i++) {


                if (colInMatrix + i > cols) {
                    aditionalColonIsValid = false;
                } else if (colInMatrix - i < 0) {
                    subColonIsValid = false;
                } else if (rowInMatrix - i < 0) {
                    subRowIsValid = false;
                } else if (rowInMatrix + i <= rows) {
                    aditionalRowisValid = true;
                }


                if (subColonIsValid) {
                    matrix[rowInMatrix][colInMatrix - i] = 0;
                }
                if (aditionalColonIsValid) {
                    matrix[rowInMatrix][colInMatrix + i] = 0;
                }
//                if (aditionalRowisValid){
//                    matrix[rowInMatrix + i][colInMatrix] = 0;
//                }
                if (subRowIsValid) {
                    matrix[rowInMatrix - i][colInMatrix] = 0;
                }

//                if (colInMatrix - i < 0 || matrix[rowInMatrix][colInMatrix - i] == 0) {
//                    continue;
//                } else {
//                    matrix[rowInMatrix][colInMatrix - i] = 0;
//                }

//                if (colInMatrix + i > cols-1 || matrix[rowInMatrix][colInMatrix + i] == 0) {
//                    continue;
//                } else {
//                    matrix[rowInMatrix][colInMatrix + i] = 0;
//                }
//                if (rowInMatrix - i < 0 || matrix[rowInMatrix - i][colInMatrix] == 0) {
//                    continue;
//                } else {
//                    matrix[rowInMatrix - i][colInMatrix] = 0;
//                }
                if (rowInMatrix + i < matrix.length) {
                    matrix[rowInMatrix + i][colInMatrix] = 0;
                }
            }
            command = reader.readLine();
        }

        printingMatrix(matrix, rows, cols);
    }

    private static void printingMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[row][col] + " ");
                }

            }
            System.out.println();
        }
    }
}
