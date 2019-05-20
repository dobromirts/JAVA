package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    @Override
    public void run() {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String input=bufferedReader.readLine();
            while (!input.equals("End")){
                String[]commands=input.split("\\\\");




            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
