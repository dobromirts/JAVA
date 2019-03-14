package opinionpoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotations = Integer.parseInt(scanner.nextLine());

        List<Person>people=new ArrayList<>();

        for (int i = 0; i < rotations; i++) {
            String[] personInformation = scanner.nextLine().split(" ");
            String name = personInformation[0];
            int age = Integer.parseInt(personInformation[1]);

            Person person=new Person(name,age);
            people.add(person);

        }
        people.stream().filter(person -> person.getAge()>30).sorted(Comparator.comparing(Person::getName))
                .forEach(entr->{
                    System.out.println(String.format(String.format("%s - %d",entr.getName(),entr.getAge())));
                });

//        for (Person person : people) {
//            System.out.println(String.format("%s - %d",person.getName(),person.getAge()));
//        }

    }
}
