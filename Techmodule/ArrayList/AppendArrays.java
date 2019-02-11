import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|+");

        List<String> result = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            List<String> currentElement = Arrays.stream(input[i].split("\\s+")).collect(Collectors.toList());

            result.addAll(currentElement);
        }

        result.stream().filter(e -> !e.equals("")).forEach(e -> System.out.print(e + " "));
    }
}
