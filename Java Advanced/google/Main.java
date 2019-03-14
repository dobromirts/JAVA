import model.Person;
import sub.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        String input = bufferedReader.readLine();

        while (!input.equals("End")) {
            String[] lines = input.split("\\s+");
            String personName = lines[0];
            String element = lines[1];

            Person person = people.get(personName);

            if (person == null) {
                person = new Person(personName);
            }

            String elementName = lines[2];
            if (element.equals("company")) {
                String department = lines[3];
                double salary = Double.parseDouble(lines[4]);

                Company company = new Company(elementName, department, salary);
                person.setCompany(company);

            } else if (element.equals("pokemon")) {
                String type = lines[3];
                Pokemon pokemon = new Pokemon(elementName, type);
                person.getPokemons().add(pokemon);

            } else if (element.equals("parents")) {
                String birthday = lines[3];
                Parent parent = new Parent(elementName, birthday);
                person.getParents().add(parent);

            } else if (element.equals("children")) {
                String birthday = lines[3];
                Children children = new Children(elementName, birthday);
                person.getChildren().add(children);

            } else if (element.equals("car")) {
                int speed = Integer.parseInt(lines[3]);
                Car car = new Car(elementName, speed);
                person.setCar(car);
            }
            people.put(personName, person);
            input = bufferedReader.readLine();
        }

        String personName = bufferedReader.readLine();
        System.out.println(people.get(personName));
    }
}
