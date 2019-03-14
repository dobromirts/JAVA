package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Balanced {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String paretheses=reader.readLine();

        Deque<Character>stack=new ArrayDeque<>();

        for (int i = 0; i <paretheses.length() ; i++) {
            if (paretheses.charAt(i)=='{'){
                stack.push(paretheses.charAt(i));
            }else if (paretheses.charAt(i)=='('){
                stack.push(paretheses.charAt(i));
            }else if (paretheses.charAt(i)=='['){
                stack.push(paretheses.charAt(i));
            }

            if (stack.isEmpty()){
                System.out.println("NO");
                return;
            }

            if (paretheses.charAt(i)=='}'){
                char symbol=stack.pop();
                if (symbol!='{'){
                    System.out.println("NO");
                    return;
                }
            }else if (paretheses.charAt(i)==')'){
                char symbol=stack.pop();
                if (symbol!='('){
                    System.out.println("NO");
                    return;
                }
            }else if (paretheses.charAt(i)==']'){
                char symbol=stack.pop();
                if (symbol!='['){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
