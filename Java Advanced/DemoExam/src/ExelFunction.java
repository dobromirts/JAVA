import java.util.Scanner;

public class ExelFunction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int rows=Integer.parseInt(scanner.nextLine());

        String[][]matrix=new String[rows][];
        for (int row = 0; row <rows ; row++) {
            matrix[row]=scanner.nextLine().split(", ");
        }

        String[]commands=scanner.nextLine().split(" ");
        switch (commands[0]){
            case "hide":
                break;
            case "sort":
                String param=commands[1];

                break;
            case "filter":
                break;
        }

    }
}
