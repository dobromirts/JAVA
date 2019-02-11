import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>numbers= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int[]bombNum= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int specialNum=bombNum[0];
        int power=bombNum[1];

        while (numbers.contains(specialNum)){

            int index=numbers.indexOf(specialNum);
            int begi=index-power;
            begi=Math.max(0,begi);

            for (int i = begi; i < index; i++) {
                numbers.remove(begi);
            }
            index=numbers.indexOf(specialNum);

            int end=Math.min((power+index),numbers.size()-1);
            for (int i = index; i <= end; i++) {
                numbers.remove(index);
            }

        }
        int sum=0;

        for (Integer number : numbers) {
            sum+=number;
            
        }
        System.out.println(sum);

    }
}
