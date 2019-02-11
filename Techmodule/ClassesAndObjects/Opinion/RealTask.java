package Opinion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RealTask {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        List<Person>people=new ArrayList<>();

        while (n-->0){
            String[]input=scanner.nextLine().split(" ");
            String nam=input[0];
            int age=Integer.parseInt(input[1]);

            Person person=new Person(nam,age);


            people.add(person);
        }


        people=people.stream().filter(person->person.getAge()>30).collect(Collectors.toCollection(ArrayList::new));

        people.stream().sorted(Comparator.comparing(Person::getName))
                .forEach(p-> System.out.println(p.toString()));


    }
}
