package listener;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Dispatcher dispatcher=new Dispatcher();
        NameChangeListener firstObserver=new EventHandlerPrinter();
        //second observer

        dispatcher.addObserver(firstObserver);

        String input=scanner.nextLine();
        while (!input.equals("End")){
            dispatcher.setName(input);


            input=scanner.nextLine();
        }
    }
}
