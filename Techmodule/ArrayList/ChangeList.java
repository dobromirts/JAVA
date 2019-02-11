import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] comArgs = command.split("\\s+");
            String firstCom = comArgs[0];
            if (firstCom.equals("Delete")) {
                int num = Integer.parseInt(comArgs[1]);
                while (numbers.contains(num)){
                    numbers.remove(Integer.valueOf(num));
                }
            } else {
                int possition = Integer.parseInt(comArgs[2]);
                int element = Integer.parseInt(comArgs[1]);
                if (possition > numbers.size()-1) {
                    break;
                } else {
                    numbers.add(possition, element);
                }


            }


            command = scanner.nextLine();
        }
        numbers.forEach(s -> System.out.print(s + " "));
    }
}
