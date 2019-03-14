package customListWithSorter;

import java.util.Scanner;

public class Engine implements Runnable{
    private static final String END_COMMAND="END";
    private  Scanner scanner;
    private String input;
    private CommandParser commandParser;

    public Engine() {
        this.scanner = new Scanner(System.in);
        this.commandParser=new CommandParser();
        this.input="";
    }

    @Override
    public void run() {
        this.input=this.scanner.nextLine();
        while (!this.input.equals(Engine.END_COMMAND)){

            this.commandParser.execute(this.input);



            this.input=this.scanner.nextLine();
        }
    }
}
