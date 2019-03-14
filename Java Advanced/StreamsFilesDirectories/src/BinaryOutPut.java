import java.io.FileInputStream;

import java.io.IOException;
import java.util.Scanner;

public class BinaryOutPut {
    public static void main(String[] args) {
        String basePath = "D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
//        String outputhPath=basePath+ "\\input.txt";


        try {
            FileInputStream fileInputStream = new FileInputStream(inputPath);
            int oneByte = fileInputStream.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
