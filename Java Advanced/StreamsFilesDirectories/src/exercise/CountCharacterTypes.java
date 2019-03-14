package exercise;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String basePath="D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath=basePath+"\\input.txt";
        String outputhPath=basePath+"\\1output.txt";

        FileInputStream inputStream=new FileInputStream(inputPath);
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

        PrintWriter writer=new PrintWriter(outputhPath);

        List<Character>vowels= Arrays.asList('a','e','i','o','u');
        List<Character>punctuatioMarks= Arrays.asList('?','.',',','!');

        int sumVowels=0;
        int consonantsSum=0;
        int punctoationSum=0;

        String line =reader.readLine();
        while (line!=null){
            for (int i = 0; i <line.length() ; i++) {
                if (vowels.contains(line.charAt(i))){
                    sumVowels+=1;
                }else if (punctuatioMarks.contains(line.charAt(i))){
                    punctoationSum+=1;
                }else if (line.charAt(i)==' '){
                }else {
                    consonantsSum+=1;
                }

            }

            line=reader.readLine();
        }
        writer.println("Vowels: "+sumVowels);
        writer.println("Consonants: "+consonantsSum);
        writer.println("Punctuation: "+punctoationSum);
        //Vowels: 41
        //Consonants: 72
        //Punctuation: 6

        writer.close();
    }
}
