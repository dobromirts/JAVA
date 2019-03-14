package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> result = new ArrayDeque<>();

        while (commands > 0) {
            int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int mainCommand = sequence[0];
            if (mainCommand == 1) {
                result.push(sequence[1]);
            } else if (mainCommand == 2) {
                result.pop();
            } else if (mainCommand == 3){
                int max= Collections.max(result);

                int max2=result.stream().max(Integer::compareTo).get();
//                int maxNum = Integer.MIN_VALUE;     This case does not work
//                if (result.isEmpty()){              This case does not work
//                    return;                         This case does not work
//                }
//                while (!result.isEmpty()) {
//                    int currentNum = result.pop();
//                    if (currentNum > maxNum) {
//                        maxNum = currentNum;
//                    }
//                }
                System.out.println(max);
            }
            commands--;
        }
    }
}
