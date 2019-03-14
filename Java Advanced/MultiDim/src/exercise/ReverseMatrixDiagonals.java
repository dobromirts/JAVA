package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]rowsAndCols= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=rowsAndCols[0];
        int cols=rowsAndCols[1];

        int[][]matrix=new int[rows][cols];

        for (int row = 0; row <rows ; row++) {
            int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row]=numbers;
        }

        int row=rows-1;
        int col=cols-1;

        while (row!=-1){
            int c=col;
            int r=row;
            while (c<cols&& r>=0 ){
                System.out.print(matrix[r--][c++]+ " ");
            }
            System.out.println();
            col--;

            if (col==-1){
                col=0;
                row--;
            }
        }


    }
}
