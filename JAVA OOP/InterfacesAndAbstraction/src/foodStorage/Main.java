package foodStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,Buyer>buyerHashMap=new HashMap<>();

        int peopleInput=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <peopleInput ; i++) {
            String[]personType=scanner.nextLine().split(" ");
            if (personType.length==3){
                Rebel rebel=new Rebel(personType[0],Integer.parseInt(personType[1]),personType[2]);
                buyerHashMap.putIfAbsent(personType[0],rebel);
            }else {
                Citizen citizen=new Citizen(personType[0],Integer.parseInt(personType[1]),personType[2],personType[3]);
                buyerHashMap.putIfAbsent(personType[0],citizen);
            }
        }


        int totalValueOfFood=0;

        String personName=scanner.nextLine();
        while (!personName.equals("End")){

            if (buyerHashMap.containsKey(personName)){
                buyerHashMap.get(personName).buyFood();
            }
            personName=scanner.nextLine();
        }

        for (Buyer value : buyerHashMap.values()) {
            totalValueOfFood+=value.getFood();
        }

        System.out.println(totalValueOfFood);
    }
}
