import command.Command;
import command.Context;
import exeptions.DuplicateModelExeption;

import java.util.Scanner;

public class Executor {
    private final Scanner scanner;
    private static final String END_COMMAND="End";
    private final CommandHandler commandHandler;

    Executor(){
        this.scanner = new Scanner(System.in);
        this.commandHandler=new CommandHandler();
    }

    public void  execute() throws DuplicateModelExeption {
        String line=this.scanner.nextLine();
        Context context=new Context();

        while (!line.equals(END_COMMAND)){
   
            Command command=CommandFactory.create(line);
            context.addCommand(command);



            line=this.scanner.nextLine();
        }

    }
}
