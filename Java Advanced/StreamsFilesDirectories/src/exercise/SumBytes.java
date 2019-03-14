package exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBytes {
    public static void main(String[] args) throws IOException {
            String basePath = "D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
            String inputPath = basePath + "\\input.txt";

            FileInputStream inputStream=new FileInputStream(inputPath);

            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String line=reader.readLine();
            int sum=0;
            while (line!=null){


                for (int i = 0; i <line.length() ; i++) {
                    sum+=line.charAt(i);
                }

                line=reader.readLine();
            }
            System.out.println(sum);
        }
    }

