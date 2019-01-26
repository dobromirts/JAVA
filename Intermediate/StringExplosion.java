import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        String result="";

        for (int i = 0; i <input.length() ; i++) {
            char symbol=input.charAt(i);
            if (symbol=='>'){
                result+=symbol;
                i++;
                int explosion=input.charAt(i)-'0';
                explosion--;
                while (explosion>0 && i<input.length()-1){
                    i++;
                    symbol=input.charAt(i);
                    if (symbol=='>'){
                        result+=symbol;
                        i++;
                        explosion+=input.charAt(i)-'0';
                        explosion--;
                        continue;
                    }
                        explosion--;
                }

            }else {
                result+=symbol;
            }
        }


        System.out.println(result);
    }
}
