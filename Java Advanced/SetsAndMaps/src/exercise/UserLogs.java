package exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, LinkedHashMap<String,Integer>> countByUsers = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String []tokens=input.split("\\s+");

            int indexIp=tokens[0].lastIndexOf("=");
            int indexUser=tokens[2].lastIndexOf("=");


            String ip =tokens[0].substring(indexIp+1);
            String user = tokens[2].substring(indexUser+1);

            if (countByUsers.containsKey(user)) {
                if (countByUsers.get(user).containsKey(ip)) {
                    int countUpdate = countByUsers.get(user).get(ip) + 1;
                    countByUsers.get(user).put(ip, countUpdate);
                } else {
                    countByUsers.get(user).put(ip, 1);
                }
            }else {
                //map.put("key", new HashMap<String, Object>());
                //map.get("key").put("key2", "val2");
                countByUsers.put(user,new LinkedHashMap<>());
                countByUsers.get(user).put(ip,1);
            }

            input=scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : countByUsers.entrySet()) {
            System.out.println(entry.getKey()+ ":");
            int count = countByUsers.get(entry.getKey()).size();

            for (Map.Entry<String, Integer> ipAddresses : entry.getValue().entrySet()) {
                count--;
                if(count > 0){
                    System.out.printf("%s => %s, ", ipAddresses.getKey(), ipAddresses.getValue());
                }else {
                    System.out.printf("%s => %s.%n", ipAddresses.getKey(), ipAddresses.getValue());
                }
            }

        }
    }
}
