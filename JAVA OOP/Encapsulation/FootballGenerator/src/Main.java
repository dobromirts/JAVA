import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        HashMap<String,Team>teamHashMap=new HashMap<>();

        String input=scanner.nextLine();
        while (!input.equals("END")){
            String[]tokens=input.split(";");

            String command=tokens[0];
            String teamName=tokens[1];

            try {
                if (command.equals("Team")){
                    teamHashMap.putIfAbsent(teamName,new Team(teamName));
                }else if (command.equals("Add")){
                    if (!teamHashMap.containsKey(teamName)){
                        throw new IllegalArgumentException("Team "+teamName+" does not exist.");
                    }
                    teamHashMap.get(teamName).addPlayer(new Player(tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7])));
                }else if (command.equals("Remove")){
                    teamHashMap.get(teamName).removePlayer(tokens[2]);
                }else {
                    if (!teamHashMap.containsKey(teamName)){
                        throw new IllegalArgumentException("Team "+teamName+" does not exist.");
                    }
                    System.out.println(teamName+" - "+(int)teamHashMap.get(teamName).getRating());
                }

            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            input=scanner.nextLine();
        }

    }
}
