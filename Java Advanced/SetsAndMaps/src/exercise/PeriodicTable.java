package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        
        int size=Integer.parseInt(reader.readLine());

        TreeSet<String>elements=new TreeSet<>();

        for (int i = 0; i <size ; i++) {
            String[]currentElements=reader.readLine().split(" ");
            elements.addAll(Arrays.asList(currentElements));
        }

        for (String element : elements) {
            System.out.print(element+" ");
        }
    }
}
