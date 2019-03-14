import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int lenght=Integer.parseInt(scanner.nextLine());

        String[]names=scanner.nextLine().split("\\s+");
        Predicate<String>checkLenght=s->s.length()<=lenght;

        Arrays.stream(names).filter(checkLenght).forEach(s-> System.out.println(s));
    }
}
