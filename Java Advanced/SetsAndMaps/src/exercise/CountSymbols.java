package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Character,Integer> occurences=new TreeMap<>();

        String input=reader.readLine();

        for (int i = 0; i <input.length() ; i++) {
            if (occurences.containsKey(input.charAt(i))){
                occurences.put(input.charAt(i),occurences.get(input.charAt(i))+1);
            }

            occurences.putIfAbsent(input.charAt(i),1);

        }

        for (Map.Entry<Character, Integer> entry : occurences.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue()+" time/s");
        }
    }
}
