import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class OrderdByAge {
    String name;
    String id;
    int age;

    public OrderdByAge(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.",this.name,this.id,this.getAge());
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        List<OrderdByAge>people=new ArrayList<>();

        while (!input.equals("End")){
            String[]tokens=input.split(" ");
            int age=Integer.parseInt(tokens[2]);

            OrderdByAge orderdByAge=new OrderdByAge(tokens[0],tokens[1],age);
            people.add(orderdByAge);


            input=scanner.nextLine();
        }
        people.stream().sorted(Comparator.comparing(OrderdByAge::getAge)).forEach(p-> System.out.println(p));
    }
}
