package militaryElite.application;

import militaryElite.inputOutput.InputReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Engine{
    public static void run() throws IOException {
        InputReader inputReader=new InputReader(new InputStreamReader(System.in),"End");
        CommandParser commandParser=new CommandParser(inputReader.readAllLines());
        commandParser.parseCommands();
    }
}
