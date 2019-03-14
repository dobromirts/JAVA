package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]size= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSize=size[0];
        int secindSize=size[1];

        LinkedHashSet<Integer>firstSet=new LinkedHashSet<>();
        LinkedHashSet<Integer>secondSet=new LinkedHashSet<>();

        for (int i = 0; i <firstSize ; i++) {
            firstSet.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < secindSize; i++) {
            secondSet.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer n : firstSet) {
            if (secondSet.contains(n)){
                System.out.print(n+" ");
            }
        }


    }
}
