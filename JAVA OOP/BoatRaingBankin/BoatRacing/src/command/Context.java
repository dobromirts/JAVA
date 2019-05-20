package command;

import repository.BoatRepository;
import repository.EngineRepository;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private EngineRepository engineRepository;
    private BoatRepository boatRepository;

    private List<Command> commands;

    public Context() {
        this.engineRepository = new EngineRepository();
        this.boatRepository = new BoatRepository();

        this.commands = new ArrayList<>();
    }

    public void execute() {
        for (Command command : commands) {
//            command.execute(this.engineRepository, this.boatRepository);
        }
    }
}
