import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Intersection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int rows=Integer.parseInt(reader.readLine());
        int cols=Integer.parseInt(reader.readLine());

        String[][]firstMatrix=new String[rows][cols];

        for (int i = 0; i <rows ; i++) {
            String[]chars= reader.readLine().split(" ");
            for (int j = 0; j <cols ; j++) {
                firstMatrix[i][j]=chars[j];
            }
        }
        String[][]secondMatrix=new String[rows][cols];

        for (int i = 0; i <rows ; i++) {
            String[]chars= reader.readLine().split(" ");
            for (int j = 0; j <cols ; j++) {
                secondMatrix[i][j]=chars[j];
            }
        }

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])){
                    System.out.print(firstMatrix[i][j]+ " ");
                }else System.out.print("* ");
            }
            System.out.println();
        }

    }
}
