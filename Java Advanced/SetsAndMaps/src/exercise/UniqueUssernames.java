package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class UniqueUssernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int number=Integer.parseInt(reader.readLine());
        LinkedHashSet<String> names=new LinkedHashSet<>();

        for (int i = 0; i <number ; i++) {
            String name=reader.readLine();
            names.add(name);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
