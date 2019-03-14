import java.util.Scanner;

public class Sneaking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows=Integer.parseInt(scanner.nextLine());

        char [][]matrix=new char[rows][];

        int []samPosition=new int[2];
        int []nikolaPosition=new int[2];

        for (int row = 0; row <rows ; row++) {
            String line=scanner.nextLine();
            matrix[row]=line.toCharArray();

            if (line.contains("N")){
                nikolaPosition[0]=row;
                nikolaPosition[1]=line.indexOf("N");
            }else if (line.contains("S")){
                samPosition[0]=row;
                samPosition[1]=line.indexOf("S");
            }
        }


        String command=scanner.nextLine();
        for (int i = 0; i <command.length() ; i++) {
            moveEnemies(matrix);

           boolean samIsDead=isSamDead(matrix,samPosition);

            if (samIsDead){
                matrix[samPosition[0]][samPosition[1]]='X';
                System.out.printf("Sam died at %d, %d",samPosition[0],samPosition[1]);
                break;
            }else {
                moveSam(matrix,samPosition,command.charAt(i));
            }


            if (nikolaPosition[0]==samPosition[0]){
                System.out.println("Nikoladze killed!");
                matrix[nikolaPosition[0]][nikolaPosition[1]]='X';
            }



        }




    }

    private static void moveSam(char[][] matrix, int[] samPosition, char charAt) {
        if (charAt=='U'){
            matrix[samPosition[0]--][samPosition[1]]='.';
            matrix[samPosition[0]][samPosition[1]]='S';
        }else if (charAt=='D'){
            matrix[samPosition[0]++][samPosition[1]]='.';
            matrix[samPosition[0]][samPosition[1]]='S';
        }else if (charAt=='L'){
            matrix[samPosition[0]][samPosition[1]--]='.';
            matrix[samPosition[0]][samPosition[1]]='S';
        }else if (charAt=='R'){
            matrix[samPosition[0]][samPosition[1]++]='.';
            matrix[samPosition[0]][samPosition[1]]='S';
        }
    }

    private static boolean isSamDead(char[][] matrix, int[] samPosition) {

        for (int i = 0; i < samPosition[1]; i++) {
            if (matrix[samPosition[0]][i]=='b'){
                return true;
            }
        }

        for (int i = samPosition[1]+1; i <matrix[samPosition[0]].length; i++) {
            if (matrix[samPosition[0]][i]=='d'){
                return true;
            }
        }
        return false;
    }

    private static void moveEnemies(char[][] matrix) {
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                if (matrix[row][col]=='b'){
                    if (col==matrix[row].length-1){
                        matrix[row][col]='d';
                    }else {
                        matrix[row][col]='.';
                        matrix[row][col+1]='b';
                        break;
                    }

                }else if (matrix[row][col]=='d'){
                    if (col==0){
                        matrix[row][col]='b';
                    }else {
                        matrix[row][col]='.';
                        matrix[row][col-1]='d';
                        break;
                    }

                }
            }

        }
    }
}
