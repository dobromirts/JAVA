import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArigmetics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input=scanner.nextLine();

        Function<int[],int[]>add=arr->Arrays.stream(arr).map(e->e+=1).toArray();
        Function<int[],int[]>sub=arr->Arrays.stream(arr).map(e->--e).toArray();
        Function<int[],int[]>multy=arr->Arrays.stream(arr).map(e->e*=2).toArray();
        Consumer<int[]>print=arr->Arrays.stream(arr).forEach(e-> System.out.print(e+" "));



        while (!input.equals("end")){
            switch (input){
                case "add":
                    numbers=add.apply(numbers);
                    break;
                case "subtract":
                    numbers=sub.apply(numbers);
                    break;
                case "multiply":
                    numbers=multy.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            input=scanner.nextLine();
        }
    }
}
