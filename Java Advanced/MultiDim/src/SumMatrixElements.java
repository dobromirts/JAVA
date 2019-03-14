import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int []rowsCols= Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows=rowsCols[0];
        int cols=rowsCols[1];

        int sum=0;
        for (int i = 0; i < rows; i++) {
            int[]sequence= Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j <cols ; j++) {
                int currentNum=sequence[j];
                sum+=currentNum;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
