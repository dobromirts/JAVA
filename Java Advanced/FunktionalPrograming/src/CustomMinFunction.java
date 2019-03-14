import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        OptionalInt minNum= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).min();

        System.out.println(minNum.getAsInt());


    }
}
