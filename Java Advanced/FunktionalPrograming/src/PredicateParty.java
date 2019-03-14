import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
        List<String> removedPeople = new ArrayList<>();
        List<String> doublePeople = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] commands = input.split(" ");

            switch (commands[1]) {
                case "StartsWith":
                    if (commands[0].equals("Remove")) {
                       // char charForCheck = commands[2].charAt(0);
                        for (String person : people) {
                            if (person.contains(commands[2])) {
                                removedPeople.add(person);
                            }

                        }
                    }else {
                        for (String person : people) {
                            if (person.contains(commands[2])) {
                                doublePeople.add(person);
                            }

                        }
                    }
                    break;
                case "Length":
                    int length = Integer.parseInt(commands[2]);
                    if (commands[0].equals("Double")) {

                        for (String person : people) {
                            if (person.length() == length) {
                                doublePeople.add(person);
                            }
                        }
                    }else {
                        for (String person : people) {
                            if (person.length() == length) {
                                removedPeople.add(person);
                            }
                        }
                    }
                    break;
                case "EndsWith":
                    if (commands[0].equals("Double")) {
                        // char charForCheck = commands[2].charAt(0);
                        for (String person : people) {
                            if (person.contains(commands[2])) {
                                doublePeople.add(person);
                            }

                        }
                    }else {
                        for (String person : people) {
                            if (person.contains(commands[2])) {
                                removedPeople.add(person);
                            }
                        }
                    }
                    break;
            }
            if (!removedPeople.isEmpty()) {
                for (String removedPerson : removedPeople) {
                    people.remove(removedPerson);
                }

                removedPeople.clear();
            }

            if (!doublePeople.isEmpty()) {
                people.addAll(doublePeople);
                doublePeople.clear();
            }


            input = scanner.nextLine();
        }

        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            people.sort(String::compareTo);
            System.out.println(String.join(", ", people) + " are going to the party!");
        }
    }
}
