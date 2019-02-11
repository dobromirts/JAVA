import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListMnip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String commnad = scanner.nextLine();

        while (!commnad.equals("End")) {
            String[] comArgs = commnad.split(" ");
            String cmd = comArgs[0];
            switch (cmd) {
                case "Conatains":
                    int element = Integer.parseInt(comArgs[1]);
                    if (numers.contains(element)) {
                        System.out.print("Yes");
                    } else {
                        System.out.print("No such element");
                    }
                    break;
                case "Print":
                    String oddOrEven = comArgs[1];
                    if (oddOrEven.equals("even")) {
                        numers.stream().filter(n -> n % 2 == 0).forEach(e -> System.out.print(e + " "));
                    } else {
                        numers.stream().filter(n -> n % 2 == 1).forEach(e -> System.out.print(e + " "));
                    }
                    break;
                case "Get":
                    numers.stream().reduce((e1, e2) -> e1 + e2).ifPresent(System.out::print);
                    break;
                case "Filter":
                    String condition = comArgs[1];
                    int number = Integer.parseInt(comArgs[2]);
                    if (condition.equals("<")) {
                        numers.stream().filter(e -> e < number).forEach(e -> System.out.println(e + " "));
                    } else if (condition.equals(">")) {
                        numers.stream().filter(e -> e > number).forEach(e -> System.out.println(e + " "));
                    }else if (condition.equals(">=")) {
                        numers.stream().filter(e -> e >= number).forEach(e -> System.out.println(e + " "));
                    }else if (condition.equals("<=")) {
                        numers.stream().filter(e -> e <= number).forEach(e -> System.out.println(e + " "));
                    }


                    break;
            }
            System.out.println();

            commnad = scanner.nextLine();
        }
    }
}

