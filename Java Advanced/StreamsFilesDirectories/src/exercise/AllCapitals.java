package exercise;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String basePath="D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath=basePath+"\\input.txt";
        String outputhPath=basePath+"\\output.txt";

        FileInputStream fileInputStream=new FileInputStream(inputPath);
        BufferedReader reader=new BufferedReader(new InputStreamReader(fileInputStream));
        PrintWriter writer=new PrintWriter(outputhPath);

        String line=reader.readLine();
        while (line!=null){
            writer.println(line.toUpperCase());





            line=reader.readLine();
        }
        writer.close();
    }
}
