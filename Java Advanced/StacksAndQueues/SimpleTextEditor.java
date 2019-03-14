package Exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int commands=Integer.parseInt(scanner.nextLine());

        StringBuilder builder=new StringBuilder();
        ArrayDeque<StringBuilder>stack=new ArrayDeque<>();


        for (int i = 0; i <commands ; i++) {
            String[]tokens=scanner.nextLine().split(" ");
            String command=tokens[0];

            switch (command){
                case "1":
                    builder.append(tokens[1]);

                    stack.push(new StringBuilder(builder));
                    break;
                case "2":
                    int count=Integer.parseInt(tokens[1]);
                    int start=builder.length()-count;
                    builder.delete(start,start+count);

                    stack.push(new StringBuilder(builder));
                    break;
                case "3":
                    int index=Integer.parseInt(tokens[1]);
                    System.out.println(builder.charAt(index-1));
                    break;
                case "4":
                    if (stack.size()>1) {
                        stack.pop();
                        builder = stack.peek();
                    }else if (stack.size()==1){
                        builder=new StringBuilder();
                    }
                    break;
            }

        }
    }
}




