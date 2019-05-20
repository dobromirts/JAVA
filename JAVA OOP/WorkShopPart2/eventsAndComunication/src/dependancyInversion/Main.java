package dependancyInversion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();
        OperationFactory operationFactory=new OperationFactory();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("End")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equalsIgnoreCase("mode")) {

                calculator.setOperation(operationFactory.produce(tokens[1]));

            } else {
                System.out.println(calculator.calculate(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }


            input = scanner.nextLine();
        }
    }
}
