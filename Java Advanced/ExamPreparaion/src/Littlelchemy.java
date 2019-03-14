import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Littlelchemy {
    //DONE
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stoneColection = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> goldCollection = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals("Revision")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Apply":
                    int dosesAndStones = Integer.parseInt(tokens[2]);
                    if (stoneColection.size() >= dosesAndStones) {
                        for (int i = 0; i < dosesAndStones; i++) {
                            int currentStone = stoneColection.poll();
                            currentStone -= 1;
                            if (currentStone <= 0) {
                                goldCollection.push(currentStone);
                            } else {
                                stoneColection.addLast(currentStone);
                            }
                        }
                    }
                    break;
                case "Air":
                    int label = Integer.parseInt(tokens[2]);
                    if (!goldCollection.isEmpty()) {
                        int current = goldCollection.pop();
                        current += label;
                        stoneColection.addLast(current);
                    }

                    break;
            }

            command = scanner.nextLine();
        }

        for (Integer stone : stoneColection) {
            System.out.print(stone + " ");
        }
        System.out.println();
        System.out.println(goldCollection.size());
    }
}
