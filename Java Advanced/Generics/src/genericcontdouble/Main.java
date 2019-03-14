package genericcontdouble;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double n =Double.parseDouble(scanner.nextLine());
        List<Box<Double>> elements=new ArrayList<>();


        for (int i = 0; i <n ; i++) {
            double element=Double.parseDouble(scanner.nextLine());
            Box<Double> box=new Box<>(element);
            elements.add(box);
        }

        Double line=Double.parseDouble(scanner.nextLine());
        Box<Double> copmarableElement=new Box<>(line);
        int count=getBiggerCount(elements,copmarableElement);
        System.out.println(count);




    }
    public static int getBiggerCount(List<Box<Double>>list,Box<Double> compElement){
        int count=0;
        for (Box<Double> box : list) {
            if (box.compareTo(compElement)>0){
                count++;
            }
        }
        return count;
    }
}
