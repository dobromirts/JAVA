import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AminderTask {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String,Integer>pairs=new LinkedHashMap<>();

        while (!input.equals("stop")){
            String res=input;
            int quantity=Integer.parseInt(scanner.nextLine());

            if (!pairs.containsKey(res)){
                pairs.put(res,quantity);
            }else {
                pairs.put(res,pairs.get(res)+quantity);
            }


            input=scanner.nextLine();
        }
        for (String s : pairs.keySet()) {
            System.out.println(String.format("%s -> %d",s,pairs.get(s)));
        }
    }
}
