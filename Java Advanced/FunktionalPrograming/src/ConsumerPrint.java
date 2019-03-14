import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[]names=scanner.nextLine().split("\\s+");
        Consumer<String>print=message-> System.out.println(message);

        for (int i = 0; i <names.length ; i++) {
            print.accept(names[i]);

        }

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(print);//to Pravilno





    }
}
