import java.util.Scanner;

public class BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO Opravane na proverkite za izlizane

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int sapperRow = -1;
        int sapperCol = -1;
        int totalBombs = 0;

        String[][] matrix = new String[fieldSize][fieldSize];

        String[] commands = scanner.nextLine().split(",");

        for (int row = 0; row < fieldSize; row++) {
            String[] symbols = scanner.nextLine().split(" ");
            for (int col = 0; col < fieldSize; col++) {
                matrix[row][col] = symbols[col].charAt(0) + "";
                if ((symbols[col].charAt(0) + "").equals("s")) {
                    sapperCol = col;
                    sapperRow = row;
                }
                if ((symbols[col].charAt(0) + "").equals("B")) {
                    totalBombs++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "up":
                    sapperRow -= 1;
                    if (sapperRow < 0) {
                        sapperRow--;
                    } else {
                        if (matrix[sapperRow][sapperCol].equals("+")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("B")) {
                            totalBombs--;
                            matrix[sapperRow][sapperCol] = "+";
                            System.out.println("You found a bomb!");

                        } else if (matrix[sapperRow][sapperCol].equals("s")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs);
                            return;
                        }
                    }
                    break;
                case "down":
                    sapperRow++;
                    if (sapperRow >= fieldSize) {
                        sapperRow++;
                    } else {
                        if (matrix[sapperRow][sapperCol].equals("+")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("B")) {
                            totalBombs--;
                            matrix[sapperRow][sapperCol] = "+";
                            System.out.println("You found a bomb!");

                        } else if (matrix[sapperRow][sapperCol].equals("s")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs);
                            return;
                        }
                    }
                    break;
                case "right":
                    sapperCol++;
                    if (sapperCol >= fieldSize) {
                        sapperCol--;
                    } else {
                        if (matrix[sapperRow][sapperCol].equals("+")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("B")) {
                            totalBombs--;
                            matrix[sapperRow][sapperCol] = "+";
                            System.out.println("You found a bomb!");

                        } else if (matrix[sapperRow][sapperCol].equals("s")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs);
                            return;
                        }
                    }
                    break;
                case "left":
                    sapperCol--;
                    if (sapperCol < 0) {
                        sapperCol++;
                    } else {
                        if (matrix[sapperRow][sapperCol].equals("+")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("B")) {
                            totalBombs--;
                            matrix[sapperRow][sapperCol] = "+";
                            System.out.println("You found a bomb!");

                        } else if (matrix[sapperRow][sapperCol].equals("s")) {
                            continue;
                        } else if (matrix[sapperRow][sapperCol].equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs);
                            return;
                        }
                    }
                    break;
            }
        }
        if (totalBombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",totalBombs,sapperRow,sapperCol);
        }

    }


}
