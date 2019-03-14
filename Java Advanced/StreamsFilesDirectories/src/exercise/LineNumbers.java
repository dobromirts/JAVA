package exercise;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String basePath="D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath=basePath+"\\inputLineNumbers.txt";
        String outputhPath=basePath+"\\2output.txt";

        FileInputStream fileInputStream=new FileInputStream(inputPath);
        BufferedReader reader=new BufferedReader(new InputStreamReader(fileInputStream));

        PrintWriter writer=new PrintWriter(outputhPath);

        String line=reader.readLine();
        int count=1;
        while (line!=null){
            writer.printf("%d. %s%n",count,line);

            line=reader.readLine();
            count++;
        }
        writer.close();
    }
}
