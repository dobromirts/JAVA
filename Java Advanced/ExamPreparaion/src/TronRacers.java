import java.util.Scanner;

public class TronRacers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];

        int[] firstPlayer = new int[2];
        int firstPlayerRow = 0;
        int firstPlayerCol = 0;
        int[] secondPlayer = new int[2];
        int secondPlayerRow = 0;
        int secondPlayerCol = 0;


        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("f")) {
                firstPlayerRow = row;
                firstPlayerCol = line.indexOf("f");
            } else if (line.contains("s")) {
                secondPlayerRow = row;
                secondPlayerCol = line.indexOf("s");
            }
        }


        boolean bothAlive = true;

        while (bothAlive) {
            String[] tokens = scanner.nextLine().split(" ");
            String firstCommand = tokens[0];
            String secondCommand = tokens[1];

//            moveFirstPlayer(matrix, firstPlayer, firstCommand);
//            moveSecondPlayer(matrix, secondPlayer, secondCommand);


            if (firstCommand.equals("up")) {
                if (matrix[firstPlayerRow-1][firstPlayerCol] == '*') {
                    matrix[firstPlayerRow-1][firstPlayerCol] = 'f';
                } else if (matrix[firstPlayerRow-1][firstPlayerCol] == 's') {
                    matrix[firstPlayerRow-1][firstPlayerCol] = 'x';
                    firstPlayerRow--;
                    bothAlive = false;
                }
            } else if (firstCommand.equals("down")) {
                if (matrix[firstPlayerRow+1][firstPlayerCol] == '*') {
                    matrix[firstPlayerRow+1][firstPlayerCol] = 'f';
                } else if (matrix[firstPlayerRow+1][firstPlayerCol] == 's') {
                    matrix[firstPlayerRow+1][firstPlayerCol] = 'x';
                    firstPlayerRow++;
                    bothAlive = false;
                }

            } else if (firstCommand.equals("left")) {
                if (matrix[firstPlayerRow][firstPlayerCol-1] == '*') {
                    matrix[firstPlayerRow][firstPlayerCol-1] = 'f';
                } else if (matrix[firstPlayerRow][firstPlayerCol-1] == 's') {
                    matrix[firstPlayerRow][firstPlayerCol-1] = 'x';
                    firstPlayerCol--;
                    bothAlive = false;
                }
            } else if (firstCommand.equals("right")) {
                if (matrix[firstPlayerRow][firstPlayerCol+1] == '*') {
                    matrix[firstPlayerRow][firstPlayerCol+1] = 'f';
                } else if (matrix[firstPlayerRow][firstPlayerCol+1] == 's') {
                    matrix[firstPlayerRow][firstPlayerCol+1] = 'x';
                    firstPlayerCol++;
                    bothAlive = false;
                }
            }

            if (!bothAlive) {
                return;
            }


            if (secondCommand.equals("up")) {
                if (matrix[secondPlayerRow-1][secondPlayerCol] == '*') {
                    matrix[secondPlayerRow-1][secondPlayerCol] = 's';
                } else if (matrix[secondPlayerRow-1][secondPlayerCol] == 'f') {
                    matrix[secondPlayerRow-1][secondPlayerCol] = 'x';
                    secondPlayerRow--;
                    bothAlive = false;
                }
            } else if (secondCommand.equals("down")) {
                if (matrix[secondPlayerRow+1][secondPlayerCol] == '*') {
                    matrix[secondPlayerRow+1][secondPlayerCol] = 's';
                } else if (matrix[secondPlayerRow+1][secondPlayerCol] == 'f') {
                    matrix[secondPlayerRow+1][secondPlayerCol] = 'x';
                    secondPlayerRow++;
                    bothAlive = false;
                }

            } else if (secondCommand.equals("left")) {
                if (matrix[secondPlayerRow][secondPlayerCol-1] == '*') {
                    matrix[secondPlayerRow][secondPlayerCol-1] = 's';
                } else if (matrix[secondPlayerRow][secondPlayerCol-1] == 'f') {
                    matrix[secondPlayerRow][secondPlayerCol-1] = 'x';
                    secondPlayerCol--;
                    bothAlive = false;
                }
            } else if (secondCommand.equals("right")) {
                if (matrix[secondPlayerRow][secondPlayerCol+1] == '*') {
                    matrix[secondPlayerRow][secondPlayerCol+1] = 's';
                } else if (matrix[secondPlayerRow][secondPlayerCol+1] == 'f') {
                    matrix[secondPlayerRow][secondPlayerCol+1] = 'x';
                    secondPlayerCol++;
                    bothAlive = false;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}


