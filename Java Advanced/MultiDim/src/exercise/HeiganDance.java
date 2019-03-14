package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeiganDance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int playerRow = 7;
        int playerCol = 7;

        int playerHp = 18500;
        double heiganHp = 3000000;

        double playerDamage = Double.parseDouble(reader.readLine());
        String lastSpell = "";
        while (true) {
            if (playerHp >= 0) {
                heiganHp -= playerDamage;
            }
            if (lastSpell.equals("Cloud")) {
                playerHp -= 3500;
            }
            if (heiganHp <= 0 || playerHp <= 0) {
                break;
            }

            String[] input = reader.readLine().split(" ");
            String currentSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);

            if (isInDamageArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInDamageArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHp -= 3500;
                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHp -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }


        }
        if (lastSpell.equals("Cloud")) {
            lastSpell = "Plague Cloud";
        } else {
            lastSpell = "Eruption";
        }

        String heiganState ="";
        if (heiganHp <= 0) {
            heiganState = "Heigan: Defeated!";
            System.out.println("Heigan: Defeated!");
        } else {
            heiganState = "Heigan: "+heiganHp;
            System.out.printf("Heigan: %.2f%n",heiganHp);
        }

        String playerState = "";
        if (playerHp <= 0) {
            playerState = "Player: Killed by "+lastSpell;
        } else {
            playerState = "Player: "+playerHp;
        }
        String playerEndCoordinates = "Final position: " +playerRow+", " +playerCol;


        //System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);



    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}


