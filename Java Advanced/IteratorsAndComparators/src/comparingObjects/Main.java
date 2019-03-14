package comparingObjects;


import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        TreeSet<Person>peopleByNames=new TreeSet<>(new CoparatorPeopleByNames());
        TreeSet<Person>peopleByAges=new TreeSet<>(new ComparatorPeopleByAge());

        while (n-->0){
            String []tokens=scanner.nextLine().split(" ");
            Person person=new Person(tokens[0],Integer.parseInt(tokens[1]));
            peopleByNames.add(person);
            peopleByAges.add(person);

        }

        for (Person peopleByName : peopleByNames) {
            System.out.println(peopleByName.toString());
        }
        for (Person peopleByAge : peopleByAges) {
            System.out.println(peopleByAge.toString());
        }

    }
}
