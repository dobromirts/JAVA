import command.Command;
import command.Context;
import exceptions.*;

import java.util.Scanner;

public class Executor {
    private static final String END_COMMAND = "End";

    private final Scanner scanner;
    private final CommandHandler commandHandler;

    Executor() {
        this.scanner = new Scanner(System.in);
        this.commandHandler = new CommandHandler();
    }

    public void execute() throws DuplicateModelException, ArgumentException, NoSetRaceException, InsufficientContestantsException, RaceAlreadyExistsException {
        String line = this.scanner.nextLine();
        Context context = new Context();

        while (!line.equals(END_COMMAND)) {
            this.commandHandler.handle(line.split("\\\\"));

//            Command command = CommandFactory.create(line);
//            context.addCommand(command);


            line = this.scanner.nextLine();
        }

        context.execute();
    }
}
