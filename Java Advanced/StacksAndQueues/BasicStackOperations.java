package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int indexes[] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lineOfNumbers[] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int elementToPush = indexes[0];
        int elementsToPop = indexes[1];
        int checkPresent = indexes[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < elementToPush; i++) {
            numbers.push(lineOfNumbers[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            numbers.pop();
        }

        if (numbers.contains(checkPresent)) {
            System.out.println("true");
        } else {
            if (numbers.isEmpty()) {
                System.out.println(0);
            } else {
                int minNum = Integer.MAX_VALUE;
                while (!numbers.isEmpty()) {
                    int popedElement = numbers.pop();
                    if (popedElement < minNum) {
                        minNum = popedElement;
                    }
                }
                System.out.println(minNum);
            }
        }
    }
}
