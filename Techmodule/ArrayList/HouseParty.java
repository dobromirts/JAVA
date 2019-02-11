import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int times=Integer.parseInt(scanner.nextLine());
        List<String>names= new ArrayList<>();

        while (times>0){
            String line=scanner.nextLine();
            String[]comArg=line.split("\\s+");

            String nam=comArg[0];
            if (!line.contains("not")){

                if (names.contains(nam)){
                    System.out.println(nam + " is already in the list!");
                }else {
                    names.add(nam);
                }
            }else {
                if (names.contains(nam)){
                    names.remove(nam);
                }else {
                    System.out.println(nam + " is not in the list!");
                }
            }

            times--;
        }
        names.forEach(s-> System.out.println(s+ " "));
    }
}
