import java.util.Scanner;

public class ExtactFile {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String files=scanner.nextLine();
        int lastindex=files.lastIndexOf("\\");
        String modified=files.substring(lastindex+1);

        int modi=modified.lastIndexOf(".");
        String fir=modified.substring(0,modi);
        String sec=modified.substring(modi).replaceAll("\\.","");





//        String[]extentions=modified.split("\\.");
//        String first=extentions[0];
//        String second=extentions[1];

        System.out.printf("File name: %s%n",fir);
        System.out.printf("File extension: %s",sec);



    }
}
