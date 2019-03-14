package genericcountstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        List<Box<String>>elements=new ArrayList<>();


        for (int i = 0; i <n ; i++) {
            String element=scanner.nextLine();
            Box<String>box=new Box<>(element);
            elements.add(box);
        }

        String line=scanner.nextLine();
        Box<String>copmarableElement=new Box<>(line);
        int count=getBiggerCount(elements,copmarableElement);
        System.out.println(count);




    }
    public static int getBiggerCount(List<Box<String>>list,Box<String>compElement){
        int count=0;
        for (Box<String> box : list) {
            if (box.compareTo(compElement)>0){
                count++;
            }
        }
        return count;
    }
}
