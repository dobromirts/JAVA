import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String []input=scanner.nextLine().split("\\s+");

        for (int i = 0; i <input.length ; i++) {
            String first=input[0];
            if (!Character.isLowerCase(first.charAt(0))){
                int lastIndex=first.length()-1;

                String digit=first.substring(first.charAt(0),lastIndex+1);
                int number=Integer.parseInt(digit);


            }else if (Character.isLowerCase(first.charAt(0))){


            }



        }

    }
}
