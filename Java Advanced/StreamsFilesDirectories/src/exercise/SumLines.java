package exercise;

import java.io.*;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath = basePath + "\\input.txt";

        FileInputStream inputStream=new FileInputStream(inputPath);

        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        String line=reader.readLine();
        while (line!=null){

            int sum=0;
            for (int i = 0; i <line.length() ; i++) {
                sum+=line.charAt(i);
            }
            System.out.println(sum);
            line=reader.readLine();
        }
    }
}
