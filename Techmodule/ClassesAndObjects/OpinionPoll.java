import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    private String name;
    private int age;

    public OpinionPoll(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",this.getName(),this.getAge());
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        List<OpinionPoll> people=new ArrayList<>();

        while (n-->0){
            String[]input=scanner.nextLine().split(" ");
            String nam=input[0];
            int age=Integer.parseInt(input[1]);

            OpinionPoll person=new OpinionPoll(nam,age);


            people.add(person);
        }


        people=people.stream().filter(person->person.getAge()>30).collect(Collectors.toCollection(ArrayList::new));

        people.stream().sorted(Comparator.comparing(OpinionPoll::getName))
                .forEach(p-> System.out.println(p.toString()));


    }
}
