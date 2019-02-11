import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOprators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] comArgs = command.split("\\s+");
            String nameOfComand = comArgs[0];


            if (nameOfComand.equals("Add")) {
                int firstTarg = Integer.parseInt(comArgs[1]);
                numbers.add(firstTarg);
            } else if (nameOfComand.equals("Insert")) {
                int index=Integer.parseInt(comArgs[2]);
                if (index>=0 && index<numbers.size()){
                    numbers.add(index,Integer.parseInt(comArgs[1]));
                }else {
                    System.out.println("Invalid index");
                }

            } else if (nameOfComand.equals("Remove")) {
                int index=Integer.parseInt(comArgs[1]);
                if (index>=0 && index<numbers.size()){
                    numbers.remove(index);
                }else {
                    System.out.println("Invalid index");
                }
            }else if (nameOfComand.equals("Shift")) {
                String direct=comArgs[1];
                int number=Integer.parseInt(comArgs[2]);
                number=number%numbers.size();
                if (direct.equals("left")){
                    for (int i = 0; i <number ; i++) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }
                }else {
                    for (int i = 0; i <number ; i++) {
                        numbers.add(0,numbers.get(numbers.size()-1));
                        numbers.remove(numbers.size()-1);
                    }
                }
            }


            command = scanner.nextLine();
        }
        numbers.forEach(s-> System.out.print(s+ " "));
    }
}
