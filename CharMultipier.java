import java.util.Scanner;

public class CharMultipier {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]input=scanner.nextLine().split(" ");
        String first=input[0];
        String second=input[1];
        int result=muliplyChars(first,second);
        System.out.println(result);



    }

    private static int muliplyChars(String first, String second) {
        int result=0;
        int lenght=Math.min(first.length(),second.length());
        for (int i = 0; i <lenght ; i++) {
            result+=first.charAt(i)*second.codePointAt(i);
        }

        if (first.length()>second.length()){
            for (int i = lenght; i <first.length() ; i++) {
                result+=first.charAt(i);
            }
        }else {
            for (int i = lenght; i <second.length() ; i++) {
                result+=second.charAt(i);
            }
        }



        return result;
    }
}
