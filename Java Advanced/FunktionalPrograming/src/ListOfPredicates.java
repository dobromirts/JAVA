import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        List<Integer> deviders = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .distinct()
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if (devidersInfo(i, deviders)) {
                numbers.add(i);
            }
        }

        for (Integer number : numbers) {
            System.out.print(number+" ");
        }
    }

    private static boolean devidersInfo(int n, List<Integer> deviders) {
        boolean isTrue = true;
        for (Integer devider : deviders) {
            if (n % devider != 0) {
                isTrue = false;
            }
        }

        return isTrue;
    }
}

