package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Matrixshuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]rowsAndCols= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=rowsAndCols[0];
        int cols=rowsAndCols[1];

        //int[][]matrix=new int[rows][cols];
        String[][]matrix=new String[rows][cols];

        for (int row = 0; row < rows; row++) {
           // int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String[]values=reader.readLine().split(" ");
//            matrix[row]=numbers;
            matrix[row]=values;
        }


        String command=reader.readLine();
        while (!command.equals("END")){
            String[]commands=command.split(" ");
            if (!commands[0].equals("swap")|| commands.length!=5){
                System.out.println("Invalid input!");
                command=reader.readLine();
                continue;
            }
            int row1=Integer.parseInt(commands[1]);
            int col1=Integer.parseInt(commands[2]);
            int row2=Integer.parseInt(commands[3]);
            int col2=Integer.parseInt(commands[4]);

            if (row1>rows-1 || row2>rows-1 || col1>cols-1 || col2>cols-1){
                System.out.println("Invalid input!");
                command=reader.readLine();
                continue;



            }
            String firstPlace=matrix[row1][col1];
            String secondPlace=matrix[row2][col2];

            matrix[row1][col1]=secondPlace;
            matrix[row2][col2]=firstPlace;

            for (int row = 0; row <rows ; row++) {
                for (int col = 0; col <cols ; col++) {
                    System.out.print(matrix[row][col]+" ");
                }
                System.out.println();
            }



            command=reader.readLine();
        }


    }
}
