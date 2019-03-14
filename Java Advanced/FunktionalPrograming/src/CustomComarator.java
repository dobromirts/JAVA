import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CustomComarator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[]numbers= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer>evenNums=new ArrayList<>();
        List<Integer>oddNums=new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2==0){
                evenNums.add(numbers[i]);
            }else {
                oddNums.add(numbers[i]);
            }
        }
        evenNums.sort(Integer::compareTo);
        oddNums.sort(Integer::compareTo);

        for (Integer evenNum : evenNums) {
            System.out.print(evenNum+ " ");
        }

        for (Integer oddNum : oddNums) {
            System.out.print(oddNum+" ");
        }



    }
}
