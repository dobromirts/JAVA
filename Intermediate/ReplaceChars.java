import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class ReplaceChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        List<Character>chars=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i <input.length()-1 ; i++) {
            char symbol=input.charAt(i);
            if (symbol!=input.charAt(i+1)){
                sb.append(symbol);
            }
        }
        System.out.print(sb);
        System.out.print(input.charAt(input.length()-1));
    }
}
