import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        List<Integer> wagons= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Integer maxCapacity=Integer.parseInt(scanner.nextLine());

        String command=scanner.nextLine();

        while (!command.equals("end")){
            String[]agument=command.split(" ");
            if (agument[0].equals("Add")){
                int passangers=Integer.parseInt(agument[1]);

                wagons.add(passangers);
            }else {
                int passangers=Integer.parseInt(agument[0]);
                for (int i = 0; i <wagons.size(); i++) {
                    int freeSpace=maxCapacity-wagons.get(i);
                    if (freeSpace>=passangers){
                        int result=wagons.get(i)+passangers;
                        wagons.set(i,result);
                        break;
                    }
                }
            }


            command=scanner.nextLine();
        }
        wagons.forEach(s-> System.out.print(s+ " "));
    }
}
