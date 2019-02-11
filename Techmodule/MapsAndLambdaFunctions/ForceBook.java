import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String, List<String>>lightUsers=new HashMap<>();
        Map<String, List<String>>darkUsers=new HashMap<>();

        while (!input.equals("Lumpawaroo")){
            String[]tokens=input.split(" ");
            String differece=tokens[1];

            if (differece.equals("->")){
                String user=tokens[0];
                String side=tokens[2];
                if (side.equals("Light")){
                    if (lightUsers.containsValue(user)){

                    }
                }

            }else {
                String side=tokens[0];
                String user=tokens[2];
                if (side.equals("Light")) {
                    lightUsers.putIfAbsent(side, new ArrayList<>());
                    if (!lightUsers.get(side).contains(user)) {
                        lightUsers.get(side).add(user);
                    }
                }else {
                    darkUsers.putIfAbsent(side, new ArrayList<>());
                    if (!darkUsers.get(side).contains(user)) {
                        darkUsers.get(side).add(user);
                    }
                }




            }





            input=scanner.nextLine();
        }
    }
}
