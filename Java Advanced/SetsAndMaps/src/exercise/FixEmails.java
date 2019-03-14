package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,String>emailsByPerson=new LinkedHashMap<>();

        String input=reader.readLine();

        while (!input.equals("stop")){
            String name=input;
            String email=reader.readLine();
//            int index=email.lastIndexOf(".");
//            String domain=email.substring(index+1);

            Pattern pattern=Pattern.compile("\\.[usukcom]+");
            Matcher matcher=pattern.matcher(email);
            if (matcher.find()){
                input=reader.readLine();
                continue;
            }else {
                emailsByPerson.putIfAbsent(name,email);
            }


//            if (!domain.equals("us")){
//                emailsByPerson.putIfAbsent(name,email);
//            }else if (!domain.equals("uk")){
//                emailsByPerson.putIfAbsent(name,email);
//            }else if (!domain.equals("com")){
//                emailsByPerson.putIfAbsent(name,email);
//            }


            input=reader.readLine();
        }

        for (Map.Entry<String, String> entry : emailsByPerson.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }
    }
}
