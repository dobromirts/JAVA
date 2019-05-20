package telephony;

import java.util.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
        List<String> sitesToVisit = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));

        Smartphone smartPhone = new Smartphone(phoneNumbers, sitesToVisit);


        System.out.print(smartPhone.call());
        System.out.print(smartPhone.browse());


    }
}
