import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInSting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> symbolPairs = new LinkedHashMap<>();


        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol != ' ') {
                if (!symbolPairs.containsKey(symbol)) {
                    symbolPairs.put(symbol, 1);
                } else {
                    symbolPairs.put(symbol, symbolPairs.get(symbol) + 1);
                }
            }
        }
        for (Character character : symbolPairs.keySet()) {
            System.out.println(String.format("%s -> %d", character, symbolPairs.get(character)));
        }
    }
}
