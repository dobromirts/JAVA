import java.util.Arrays;
import java.util.Scanner;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[]numbers= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int smallestNum=Integer.MAX_VALUE;
        int bestIndex=-1;

        for (int i = 0; i <numbers.length ; i++) {
            if (numbers[i]==smallestNum){
                if (i>bestIndex){
                    bestIndex=i;
                }

            }
            if (numbers[i]<smallestNum){
                smallestNum=numbers[i];
                bestIndex=i;
            }
        }


        //V uprajneniet ima reshenie s list Osnovni komani .min / .get return na funkciqta reshena s list

        System.out.println(bestIndex);
    }
}
