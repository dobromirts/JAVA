import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String,Double> itemByPrice = new HashMap<>();
        Map<String,Integer> itemByQuantity = new HashMap<>();
        Map<String,Double> result = new LinkedHashMap<>();

        double sum = 0;
        String line = scanner.nextLine();
        while(!line.equals("buy")){
            String[] reciet = line.split(" ");
            String item = reciet[0];
            double price = Double.parseDouble(reciet[1]);
            int quantity = Integer.parseInt(reciet[2]);

            if(!itemByPrice.containsKey(item)){
                itemByPrice.put(item,price);
            }
            double oldPrice = itemByPrice.get(item);
            if(oldPrice != price){
                itemByPrice.put(item,price);
            }



            if(!itemByQuantity.containsKey(item)){
                itemByQuantity.put(item,quantity);
            }else{
                itemByQuantity.put(item,itemByQuantity.get(item) + quantity);
            }

            sum = itemByQuantity.get(item) * itemByPrice.get(item);
            result.put(item,sum);


            line = scanner.nextLine();
        }

        result.forEach((k,v) -> {
            System.out.print(k + " -> ");
            System.out.printf("%.2f%n",v);
        });


    }
}