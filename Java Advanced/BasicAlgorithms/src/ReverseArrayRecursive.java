import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayRecursive {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[]array= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        printReversedArray(array,array.length-1);

    }

    private static void printReversedArray(int[] array, int index) {
        if (index<0){
            return;
        }
        System.out.print(array[index]+" ");

        printReversedArray(array,index-1);
    }

}
