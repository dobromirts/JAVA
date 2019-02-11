import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExam {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String,Integer>languafes=new HashMap<>();
        Map<String,Integer>usersPoitns=new HashMap<>();


        while (!input.equals("exam finished")){
            String[]tokens=input.split("-");
            String command=tokens[1];
            String username=tokens[0];

            if (command.equals("banned")){
                usersPoitns.remove(username);

            }else {
                int points=Integer.parseInt(tokens[2]);
                if (usersPoitns.containsKey(username)){
                    usersPoitns.put(username,points);
                }
                usersPoitns.putIfAbsent(username,points);
                if (languafes.containsKey(command)){
                    languafes.put(command,languafes.get(command)+1);
                }
                languafes.putIfAbsent(command,1);

            }


            input=scanner.nextLine();
        }
        System.out.println("Results:");
        usersPoitns.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed().
                thenComparing(Map.Entry.comparingByKey())).
                forEach(entry->{
                    System.out.print(String.format("%s | %d%n",entry.getKey(),entry.getValue()));
                });
        System.out.println("Submissions:");
        languafes.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(w->{

            System.out.print(String.format("%s - %d%n",w.getKey(),w.getValue()));
        });

    }
}
