
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]customers=scanner.nextLine().split(";");
        String[]productsWithPrices=scanner.nextLine().split(";");


        LinkedHashMap<String,Person>people=new LinkedHashMap<>();
        LinkedHashMap<String,Product>products=new LinkedHashMap<>();

        for (String customer : customers) {
            String[]nameAndMoney=customer.split("=");
            Person person=new Person(nameAndMoney[0],Double.parseDouble(nameAndMoney[1]));

            people.putIfAbsent(person.getName(),person);
        }
        for (String productsWithPrice : productsWithPrices) {
            String[]productAndCost=productsWithPrice.split("=");
            Product product=new Product(productAndCost[0],Double.parseDouble(productAndCost[1]));

            products.putIfAbsent(product.getName(),product);
        }

        String command=scanner.nextLine();
        while (!command.equals("END")){
            String[]tokens=command.split(" ");
            String currentPerson=tokens[0];
            String currentProduct=tokens[1];

            if (people.containsKey(currentPerson) && products.containsKey(currentProduct)) {
                people.get(currentPerson).buyProduct(products.get(currentProduct));
            }
            command=scanner.nextLine();
        }


        for (Person person : people.values()) {
            if (person.getProducts().isEmpty()){
                System.out.printf("%s – Nothing bought%n",person.getName());
            }else {
                System.out.print(person.getName()+ " - ");
                person.forEach(e-> System.out.print(e+", "));
                System.out.println();
            }
        }



    }
}
