import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

       ArrayList<Integer>numbers= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed()
               .collect(Collectors.toCollection(ArrayList::new));

       int dividedNum=Integer.parseInt(scanner.nextLine());


        BiFunction<ArrayList<Integer>,Integer, ArrayList<Integer>>dividing=((arr,num)->{
            Collections.reverse(arr);
            return arr.stream().filter(e->e%num!=0).collect(Collectors.toCollection(ArrayList::new));
        });

        dividing.apply(numbers,dividedNum).stream().forEach(e-> System.out.print(e+" "));
    }
}
