package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[]parameters= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=parameters[0];
        int cols=parameters[1];
        int[][]parking=new int[rows][cols];

        String command=reader.readLine();
        while (!command.equals("stop")){
            int []tokens= Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int startingRow=tokens[0];
            int startingCol=0;
            int targetRow=tokens[1];
            int targetCol=tokens[2];

            if (parking[targetRow][targetCol]==1){
                String bestDistance="";
                int[] cords=new int[2];
                for (int i = 1; i <cols ; i++) {
                    if(parking[targetRow][i]!=1){
                        bestDistance=""+targetRow+" "+i;
                        cords[0]=targetRow;
                        cords[1]=i;
                        break;
                    }
//                    findingFirstFreeSpace(parking,targetRow,targetCol);

                }
                if (bestDistance.equals("")){
                    System.out.printf("Row %d full%n",targetRow);
                }else {
                    int[]findCordinates= Arrays.stream(bestDistance.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int colonFind=cords[1];

                    int cellsToTargetRow=targetRow-startingRow;
                    int cellsToTargetCol=colonFind-startingCol;


                    int fullDistance=(cellsToTargetCol+cellsToTargetRow)+1;
                    System.out.println(fullDistance);
                    parking[targetRow][cords[1]]=1;

                }
            }else {
                parking[targetRow][targetCol]=1;
                int cellsToTargetRow=targetRow-startingRow;
                int cellsToTargetCol=targetCol-startingCol;


                int fullDistance=(cellsToTargetCol+cellsToTargetRow)+1;
                System.out.println(fullDistance);

            }




            command=reader.readLine();
        }

    }

    private static void findingFirstFreeSpace(int[][] parking, int targetRow, int targetCol) {

    }
}
