import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        boolean isObtainde=false;
        Map<String,Integer>pairs=new HashMap<>();
        Map<String,Integer>junk=new TreeMap<>();             //pulnene na junk
        pairs.put("motes",0);
        pairs.put("shards",0);                          //pazq osnovnie da podsigurim printa
        pairs.put("fragments",0);

        while (!isObtainde){
            String[]tokens=scanner.nextLine().split(" ");

            for (int i = 0; i <tokens.length-1 ; i+=2) {  //stupka napred za da produljim
                int quantity=Integer.parseInt(tokens[i]);           //kogato ne znaem broikata 2ki na masiva
                String reagent=tokens[i+1].toLowerCase();

                if (reagent.equals("motes")|| reagent.equals("shards")|| reagent.equals("fragments")){
                    pairs.put(reagent,pairs.get(reagent)+quantity);

                    if (pairs.get(reagent)>=250){
                        pairs.put(reagent,pairs.get(reagent)-250);

                        if (reagent.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                        }else if (reagent.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else {
                            System.out.println("Valanyr obtained!");
                        }
                        isObtainde=true;
                        break; // i osven tova setvam na true za da spre while
                    }
                }else {
                    if (!junk.containsKey(reagent)){
                        junk.put(reagent,quantity);
                    }else {
                        junk.put(reagent,junk.get(reagent)+quantity);
                    }
                }

            }


            //TODO close the loop
        }

        pairs.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry->{
                    System.out.println(String.format("%s: %d",entry.getKey(),entry.getValue()));
                });

        junk.forEach((k,v)->{
            System.out.println(String.format("%s: %d",k,v));
        });
    }
}
