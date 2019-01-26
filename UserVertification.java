import java.util.Scanner;

public class UserVertification {


    public static boolean isValid(String username){
        if (username.length()<3 || username.length()>16){
            return false;
        }
        for (int i = 0; i <username.length() ; i++) {
            char symbol=username.charAt(i);
            if (!(Character.isLetterOrDigit(symbol) || symbol=='-'|| symbol=='_')){
                return false;
            }

        }
        return  true;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String [] names=scanner.nextLine().split(", ");


        for (int i = 0; i <names.length; i++) {
            String currentName=names[i];

            if (isValid(names[i])){
                System.out.println(names[i]);
            }
        }

    }
}
