package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int []iput=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=iput[0];
        int cols=iput[1];

        String[][]matrix=new String[rows][cols];

        for (int row = 0; row <rows ; row++) {
            for (int col = 0; col <cols; col++) {
                String element=""+(char)('a'+row)+(char)('a'+row + col) + (char)('a'+row);
                matrix[row][col]=element;

            }
        }

        for (int i = 0; i <matrix.length; i++) { //dava redovete
            for (int j = 0; j <matrix[i].length ; j++) {//dava colonite
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }


    }
}
