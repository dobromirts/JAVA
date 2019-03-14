package genericbox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            String line=scanner.nextLine();

            Box box=null;

            try{
                int number=Integer.parseInt(line);
                box=new Box<Integer>(number);
                System.out.println(box.toString());
            }catch (Exception e){
                box=new Box<String>(line);
                System.out.println(box.toString());

            }

        }
    }
}
