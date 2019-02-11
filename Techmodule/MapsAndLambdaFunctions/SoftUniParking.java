import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String>parkingUsers=new LinkedHashMap<>();

        int n =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String[]tokens=scanner.nextLine().split(" ");
            String command=tokens[0];
            String username=tokens[1];

            if (command.equals("register")){
                String plate=tokens[2];
                if (parkingUsers.containsKey(username)){
                    System.out.println(String.format("ERROR: already registered with plate number %s",plate));
                    continue;
                }
                parkingUsers.putIfAbsent(username,plate);
                System.out.println(String.format("%s registered %s successfully",username,plate));

            }else {
                if (!parkingUsers.containsKey(username)){
                    System.out.println(String.format("ERROR: user %s not found",username));
                }else {
                    System.out.println(String.format("%s unregistered successfully",username));
                    parkingUsers.remove(username);
                }

            }
        }
        parkingUsers.forEach((k,v)->{
            System.out.printf("%s => %s%n",k,v);
        });
    }
}

