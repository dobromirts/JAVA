import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;



public class ConnectedAreasInMatrix {
    public static class Area{
        private int row;
        private int col;
        private int size;

        public Area(int row,int col,int size){
            this.row=row;
            this.col=col;
            this.size=size;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getSize() {
            return size;
        }

        public String toString(int number) {
            return String.format("Area #%d at (%d, %d), size: %d",number,this.row,this.col,this.size);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows=Integer.parseInt(scanner.nextLine());
        int cols=Integer.parseInt(scanner.nextLine());

        char[][]matrix=new char[rows][cols];
        ArrayList<Area>areas=new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            matrix[i]=scanner.nextLine().replaceAll("[\t ]+","").toCharArray();
        }



        for (int row = 0; row <rows ; row++) {
            for (int col = 0; col <cols ; col++) {
                if (matrix[row][col]=='-'){
                    int[]size=new int[1];
                    countSize(matrix,row,col,size);

                    Area area=new Area(row,col,size[0]);
                    areas.add(area);
                }
                
            }
            
        }

        AtomicInteger number= new AtomicInteger(1);

        System.out.printf("Total areas found: %d%n",areas.size());

        areas.stream().sorted((f,s)->{
            int result= s.getSize()-f.getSize();
            if (result==0){
                result=f.getRow()-s.getRow();
            }
            if (result==0){
                result=f.getCol()-s.getCol();
            }
            return result;
        }).forEach(area -> System.out.println(area.toString(number.getAndIncrement())));
    }

    private static void countSize(char[][] matrix, int row, int col, int[] size) {

        if(!isBounds(matrix,row,col)|| matrix[row][col]=='V'||matrix[row][col]=='*'){
            return;
        }



        size[0]++;
        matrix[row][col]='V';

        countSize(matrix,row+1,col,size);
        countSize(matrix,row,col+1,size);
        countSize(matrix,row-1,col,size);
        countSize(matrix,row,col-1,size);
    }

    private static boolean isBounds(char[][] matrix, int row, int col) {
        return row>=0 && row<matrix.length && col>=0 && col<matrix[row].length;
    }
}
