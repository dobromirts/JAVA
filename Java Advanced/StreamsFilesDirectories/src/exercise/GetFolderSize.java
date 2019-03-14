package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath="D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath=basePath+"\\input.txt";
        String outputhPath=basePath+"\\3output.txt";

        File file=new File("D:\\JavaAdvanced\\StreamsFilesDirectories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

       long sum= Arrays.stream(file.listFiles()).filter(e->!e.isDirectory()).mapToLong(e->e.length()).sum();
        PrintWriter writer=new PrintWriter(outputhPath);
        writer.print("Folder size: "+sum);
        writer.close();
    }
}
