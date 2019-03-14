import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]borders=reader.readLine().split(" ");
        int rows=Integer.parseInt(borders[0]);
        int cols=Integer.parseInt(borders[1]);

        int[][]firstMatrix=new int[rows][cols];

        for (int row = 0; row <rows; row++) {
            int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col]=numbers[col];
            }
        }


        String[]secondBorders=reader.readLine().split(" ");
        int secondRows=Integer.parseInt(secondBorders[0]);
        int secondCols=Integer.parseInt(secondBorders[1]);

        int[][]secondMatrix=new int[secondRows][secondCols];

        for (int row = 0; row <secondRows; row++) {
            int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < secondCols; col++) {
                secondMatrix[row][col]=numbers[col];
            }
        }
        if (firstMatrix.length!=secondMatrix.length|| cols!=secondCols){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row <rows ; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
