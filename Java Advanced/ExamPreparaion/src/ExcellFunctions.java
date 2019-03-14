import java.util.Scanner;

public class ExcellFunctions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows=Integer.parseInt(scanner.nextLine());
        String[][]matrix=new String[rows][];

        for (int i = 0; i <rows ; i++) {
            matrix[i]=scanner.nextLine().split(", ");
        }

        String []commandArgs=scanner.nextLine().split(" ");
        String header=commandArgs[1];

        switch (commandArgs[0]){
            case "hide":
                hideAndPrint(matrix,header);
                break;
            case "sort":
                sortAndPrint(matrix,rows,header);
                System.out.println();
                break;
            case "filter":
                String param=commandArgs[2];
                filterAndPrint(matrix,rows,header,param);
                break;
        }
    }

    private static void filterAndPrint(String[][] matrix, int rows, String header, String param) {
        int targetCol=0;
        for (int i = 0; i <matrix[0].length; i++) {
            if (matrix[0][i].equals(header)) {
                targetCol=i;
            }
        }
        System.out.println(String.join(" | ",matrix[0]));
        for (int i = 0; i <rows ; i++) {
            if (matrix[i][targetCol].equals(param)){
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }

    private static void sortAndPrint(String[][] matrix, int rows, String header) {
        int targetCol=0;
        for (int i = 0; i <matrix[0].length; i++) {
            if (matrix[0][i].equals(header)) {
                targetCol=i;
            }
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 1; j <matrix.length-1-i ; j++) {
                if (matrix[j][targetCol].compareTo(matrix[j+1][targetCol])>0){
                    String[]temp=matrix[j];
                    matrix[j]=matrix[j+1];
                    matrix[j+1]=temp;
                }
            }
        }
        for (int i = 0; i <matrix.length ; i++) {
            System.out.println(String.join(" | ", matrix[i]));
        }
    }

    private static void hideAndPrint(String[][] matrix,String header) {
        int targetCol=0;
        for (int i = 0; i <matrix.length; i++) {
            if (matrix[0][i].equals(header)) {
                targetCol=i;
                break;
            }
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if (j==targetCol){
                    continue;
                }
                if (j<matrix[0].length-1){
                    System.out.print(matrix[i][j]+" | ");
                }else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
