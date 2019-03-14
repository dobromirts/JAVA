package exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerialireArrayList {//Moje da se naloji smqna na imeto na clasa ArrayList
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String basePath="D:\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputPath=basePath+"\\input.txt";
        String outputhPath=basePath+"\\SerializedList.txt";//Moje i .ser da e Faila

        java.util.ArrayList<Double>list=new ArrayList<>(){{//slagame java.util za heteneto i slaganeto za da e kato template
            add(3.14);
            add(2.14);
            add(35.143);
            add(4.83);
        }};
        FileOutputStream fileOutputStream=new FileOutputStream(outputhPath);

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();




        //Chetene

        FileInputStream fileInputStream=new FileInputStream(outputhPath);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

        java.util.ArrayList<Double>dList=null;
        Object obj;
        while ((obj=objectInputStream.readObject())!=null){
            if (obj instanceof java.util.ArrayList){
                dList=(java.util.ArrayList<Double>)obj;
            }else {
                dList.add((Double)obj);

            }
        }
        objectInputStream.close();
        fileInputStream.close();

        for (Double number : dList) {//Stava za pisane i v fail pak po dr nachin
            System.out.println(number);//Taka e za proverka
        }
    }
}
