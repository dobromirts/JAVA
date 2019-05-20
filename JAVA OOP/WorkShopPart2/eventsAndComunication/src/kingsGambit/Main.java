package kingsGambit;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String kingName=scanner.nextLine();


        Map<String,Defender>defenderMap=new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e->defenderMap.put(e,new RoyalGuard(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e->defenderMap.put(e,new Footman(e)));

        King king=new King(kingName,defenderMap);

        String command=scanner.nextLine();

        while (!command.equals("End")){
            String[]tokens=command.split("\\s+");
            if (tokens[0].equalsIgnoreCase("kill")){
                      defenderMap.remove(tokens[1]);
            }else {
                king.onAttacked();
            }


            command=scanner.nextLine();
        }
    }
}
