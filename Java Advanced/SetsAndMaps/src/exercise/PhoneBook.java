package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();
        HashMap<String,String>phoneBook=new HashMap<>();

        while (!input.equals("stop")){
            if (input.equals("search")){
                String nameToFind=reader.readLine();
                if (nameToFind.equals("stop")){
                    break;
                }

                if (phoneBook.containsKey(nameToFind)){
                    System.out.printf("%s -> %s%n",nameToFind,phoneBook.get(nameToFind));
                }else {
                    System.out.printf("Contact %s does not exist.%n",nameToFind);
                }
                continue;
            }
            String[]tokens=input.split("-");
            String name=tokens[0];
            String phone=tokens[1];

            if (phoneBook.containsKey(name)){
                phoneBook.put(name,phone);
            }

            phoneBook.putIfAbsent(name,phone);

            input=reader.readLine();
        }


    }
}
