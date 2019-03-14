import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PositionsOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[]rowsCols= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=rowsCols[0];
        int cols=rowsCols[1];

        int[][]matrix=new int[rows][];

        for (int i = 0; i <rows ; i++) {
            int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i]=numbers;
        }

        int number=Integer.parseInt(reader.readLine());

        boolean isValid=false;

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (matrix[i][j]==number){
                    System.out.println(i + " "+j);
                    isValid=true;
                }
            }
        }
        if (!isValid){
            System.out.println("not found");
        }








//        for (int i = 0; i <rows ; i++) {
//            for (int j = 0; j <cols ; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
    }
}
