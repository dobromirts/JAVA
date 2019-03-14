package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> pointsByPlayer = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("JOKER")) {
            String[] firstModifing = input.split(": ");
            String name = firstModifing[0];
            String second = firstModifing[1];
            HashSet<String> cards = Arrays.stream(second.split(", ")).collect(Collectors.toCollection(HashSet::new));

            if (!pointsByPlayer.containsKey(name)) {
                pointsByPlayer.put(name, cards);
            } else {
                pointsByPlayer.get(name).addAll(cards);
            }

            input = reader.readLine();
        }
        for (String player : pointsByPlayer.keySet()) {
            int deckPower = calculateDeckPower(pointsByPlayer.get(player));
            System.out.printf("%s: %d%n",player,deckPower);
        }
    }

    private static int calculateDeckPower(HashSet<String> deck) {
        int power = 0;
        for (String card : deck) {
            int currnetPower=0;

            switch (card.charAt(0)){
                case '2':
                    currnetPower=2;
                    break;
                case '3':
                    currnetPower=3;
                    break;
                case '4':
                    currnetPower=4;
                    break;
                case '5':
                    currnetPower=5;
                    break;
                case '6':
                    currnetPower=6;
                    break;
                case '7':
                    currnetPower=7;
                    break;
                case '8':
                    currnetPower=8;
                    break;
                case '9':
                    currnetPower=9;
                    break;
                case '1':
                    currnetPower=10;
                    break;
                case 'J':
                    currnetPower=11;
                    break;
                case 'Q':
                    currnetPower=12;
                    break;
                case 'K':
                    currnetPower=13;
                    break;
                case 'A':
                    currnetPower=14;
                    break;
            }

            switch (card.charAt(card.length()-1)){
                case 'S':
                    currnetPower*=4;
                    break;
                case 'H':
                    currnetPower*=3;
                    break;
                case 'D':
                    currnetPower*=2;
                    break;

            }

//            int numberForResult = 0;
//            int multyplier = 0;
//            if (Character.isDigit(card.charAt(0))) {
//                int number = card.charAt(0);
//                currnetPower = number - '0';
//            } else {
//                if (card.charAt(0) == 'J') {
//                    currnetPower = 11;
//                }
//                if (card.charAt(0) == 'Q') {
//                    currnetPower = 12;
//                }
//                if (card.charAt(0) == 'K') {
//                    currnetPower = 13;
//                }
//                if (card.charAt(0) == 'A') {
//                    currnetPower = 14;
//                }
//            }
//
//            if (card.charAt(card.length()-1) == 'S') {
//                currnetPower *= 4;
//            } else if (card.charAt(card.length()-1) == 'H') {
//                currnetPower *= 3;
//            } else if (card.charAt(card.length()-1) == 'D') {
//                currnetPower *= 2;
//            } else if (card.charAt(card.length()-1) == 'C') {
//                currnetPower *= 1;
//            }
//
//            int currentResult = multyplier * numberForResult;
            power += currnetPower;
        }
        return power;

    }
}

