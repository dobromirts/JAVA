package exercise;

import java.io.*;
import java.util.List;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath="D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String wordsInput=basePath+"\\words.txt";
        String textInput=basePath+"\\text.txt";
        String outputhPath=basePath+"\\results.txt";

        FileInputStream fileInputStream=new FileInputStream(textInput);
        FileReader reader=new FileReader(textInput);
        BufferedReader readerr=new BufferedReader(new InputStreamReader(fileInputStream));
        PrintWriter writer=new PrintWriter(outputhPath);

        //TODO

        //Za 7ma wled vs while chetem drugiq file i zapisvame v edin outputh


    }
}
