package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ParkingSecondTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(" ");
        int rowSize = Integer.parseInt(matrixSize[0]);
        int columnSize = Integer.parseInt(matrixSize[1]);
        HashMap<Integer, ArrayList<Integer>> matrix = new HashMap<>();
        String cmd = scanner.nextLine();
        while (!cmd.equals("stop")) {
            String[] parkingSpot = cmd.split(" ");
            int startPos = Integer.parseInt(parkingSpot[0]);
            int row = Integer.parseInt(parkingSpot[1]);
            int column = Integer.parseInt(parkingSpot[2]);
            boolean freeSpot = false;
            int closestPos = column;

            if (!matrix.containsKey(row)) {
                matrix.put(row, new ArrayList<Integer>());
                fillArray(matrix, row, columnSize);
                matrix.get(row).set(column, 1);
                freeSpot = true;

            } else if (matrix.containsKey(row)
                    && matrix.get(row).get(column) != 1) {
                matrix.get(row).set(column, 1);
                freeSpot = true;

            } else {
                int marker = column;
                for (int i = column; i > 0; i--) {
                    if (matrix.get(row).get(i) != 1) {
                        marker = column - i;
                        closestPos = i;
                        freeSpot = true;
                        break;
                    }

                }

                for (int i = column; i < columnSize; i++) {

                    if (matrix.get(row).get(i) != 1) {

                        if (marker == column || marker > (i - column)) {
                            closestPos = i;
                        }
                        freeSpot = true;
                        break;
                    }
                }

            }
            if (!freeSpot) {
                System.out.printf("Row %d full\n", row);

            } else {
                matrix.get(row).set(closestPos, 1);
                int countSteps = (Math.abs(startPos - row) + closestPos + 1);
                System.out.println(countSteps);

            }
            cmd = scanner.nextLine();
        }
    }

    private static void fillArray(HashMap<Integer, ArrayList<Integer>> matrix,
                                  int row, int column) {
        matrix.get(row).add(0, 1);
        for (int i = 1; i < column; i++) {
            matrix.get(row).add(i, 0);
        }

    }
}
