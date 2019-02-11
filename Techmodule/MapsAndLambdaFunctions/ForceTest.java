import java.util.*;

public class ForceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> usersBySide = new HashMap<>();

        int count = 0;

        while (!input.equals("Lumpawaroo")) {


            if (input.contains(" | ")) {
                String[] tokens = input.split(" \\| ");
                String side = tokens[0];
                String user = tokens[1];
                usersBySide.putIfAbsent(side, new ArrayList<>());

                boolean exists = false;

                for (Map.Entry<String, List<String>> entry : usersBySide.entrySet()) {
                    List<String> users = entry.getValue();
                    if (users.contains(user)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    usersBySide.get(side).add(user);
                    count++;

                }

            } else if (input.contains(" -> ")) {
                String[] tokens = input.split(" -> ");
                String user = tokens[0];
                String side = tokens[1];
                usersBySide.putIfAbsent(side, new ArrayList<>());


                for (Map.Entry<String, List<String>> entry : usersBySide.entrySet()) {
                    List<String> users = entry.getValue();
                    if (users.contains(user)) {
                        users.remove(user);
                        break;
                    }
                }
                usersBySide.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);

            }
            input = scanner.nextLine();
        }
        usersBySide.entrySet().stream().sorted((es1, es2) -> {/////////Vajno sortirane
            int count2 = es2.getValue().size();
            int count1 = es1.getValue().size();
            if (count2 == count1) {
                return es1.getKey().compareTo(es2.getKey());
            }
            return Integer.compare(count2, count1);
        }).forEach(s -> {
            if (s.getValue().size() == 0) {
                return;
            }
            System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
            Collections.sort(s.getValue());
            s.getValue().forEach(u -> System.out.println("! " + u));

        });


    }
}



