package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AminerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        LinkedHashMap<String, Integer> materials = new LinkedHashMap<>();
        String currrnetMaterial = "";

        int counter = 1;


        while (!command.equals("stop")) {
            if (counter % 2 != 0) {
                currrnetMaterial=command;
                materials.putIfAbsent(currrnetMaterial,0);
            }else {
                int value=Integer.parseInt(command);
                materials.put(currrnetMaterial,materials.get(currrnetMaterial)+value);
            }


            counter++;
            command = reader.readLine();
        }

        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }


    }
}
