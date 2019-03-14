package genericswapmetodintegers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Box<Integer>>boxOfIntegers=new ArrayList<>();

        int n =Integer.parseInt(scanner.nextLine());



        for (int i = 0; i <n; i++) {
            int number=Integer.parseInt(scanner.nextLine());
            Box<Integer>box=new Box<>(number);
            boxOfIntegers.add(box);
        }

        int[]indexes= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstIndex=indexes[0];
        int lastIndex=indexes[1];

        swapIndexes(boxOfIntegers,firstIndex,lastIndex);

        for (Box<Integer> boxOfString : boxOfIntegers) {
            System.out.println(boxOfString);
        }



    }
    public static <T> void swapIndexes(List<T>list,int firstIndex,int lastIndex){
        T temp=list.get(firstIndex);
        list.set(firstIndex,list.get(lastIndex));
        list.set(lastIndex,temp);
    }
}