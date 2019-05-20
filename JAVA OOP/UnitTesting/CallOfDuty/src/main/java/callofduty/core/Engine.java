package callofduty.core;

import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine implements InputReader, OutputWriter {
    private final BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private static final String END_COMMAND="Over";
    private MissionManager missionManager;

    public Engine(MissionManager missionManager) {
        this.missionManager = missionManager;
    }

    public void run() throws IOException {
        String input=readLine();
        while (!input.equals(END_COMMAND)){
            String[] tokens=input.split("\\s+");
            String command=tokens[0];

            switch (command){
                case "Agent":
                    println(this.missionManager.agent(Arrays.stream(tokens).skip(1).collect(Collectors.toList())));
                    break;
                case "Request":
                    println(this.missionManager.request(Arrays.stream(tokens).skip(1).collect(Collectors.toList())));
                    break;
                case "Status:":
                    println(this.missionManager.status(Arrays.stream(tokens).skip(1).collect(Collectors.toList())));
                    break;
//                case "Complete":
//                    println(this.missionManager.complete(Arrays.stream(tokens).skip(1).collect(Collectors.toList())));
//                    break;
            }


            input=readLine();
        }

    }


    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
