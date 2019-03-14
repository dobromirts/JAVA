package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReverseNums {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numbers []= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer>stack=new ArrayDeque<>();

        for (int i = 0; i <numbers.length ; i++) {
            stack.push(numbers[i]);
        }
        for (Integer integer : stack) {
            System.out.print(integer+ " ");
        }
      //  System.out.println(stack.pop());
    }

    public static class BasicOperations {
        public static void main(String[] args) throws IOException {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

            int []indexes= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int numbersToAdd=indexes[0];
            int numbersToRemove=indexes[1];
            int numbersToCheck=indexes[2];

            int []sequence=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Deque<Integer> queue=new ArrayDeque<>();

            for (int i = 0; i <numbersToAdd ; i++) {
                queue.offer(sequence[i]);
            }
            for (int i = 0; i <numbersToRemove ; i++) {
                queue.poll();
            }

            if (queue.contains(numbersToCheck)){
                System.out.println("true");
            }else {
                if (queue.isEmpty()){
                    System.out.println(0);
                    return;
                }
                int minNum=Integer.MAX_VALUE;
                while (!queue.isEmpty()){
                    int currentNum=queue.poll();
                    if (currentNum<minNum){
                        minNum=currentNum;
                    }
                }
                System.out.println(minNum);
            }


        }
    }
}
