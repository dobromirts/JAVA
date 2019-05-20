package core;

import models.components.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private SystemComponent systemComponent;

    public Engine(SystemComponent systemComponent) {
        this.systemComponent = systemComponent;
    }

    public void run() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String input=bufferedReader.readLine();

        while (!input.equals("System split")){
            String command=input.substring(0,input.indexOf("("));
            String []cmdArgs=input.substring(input.indexOf("("+1,input.length()-1)).split(", ");


            switch (command){
                case "RegisterPowerHardware":
                    this.systemComponent.addHardware(new PowerHardware(cmdArgs[0],Integer.parseInt(cmdArgs[1]),Integer.parseInt(cmdArgs[2])));
                    break;
                case "RegisterHeavyHardware":
                    this.systemComponent.addHardware(new HeavyHardware(cmdArgs[0],Integer.parseInt(cmdArgs[1]),Integer.parseInt(cmdArgs[2])));
                    break;

                case"RegisterLightSoftware":
                    this.systemComponent.addSoftware(cmdArgs[0],new LightSoftware(cmdArgs[1],Integer.parseInt(cmdArgs[2]),Integer.parseInt(cmdArgs[3])));
                    break;
                case "RegisterExpressSoftware":
                    this.systemComponent.addSoftware(cmdArgs[0],new ExpressSoftware(cmdArgs[1],Integer.parseInt(cmdArgs[2]),Integer.parseInt(cmdArgs[3])));
                    break;
                case "ReleaseSoftwareComponent":
                    this.systemComponent.releaseSoftwareComponent(cmdArgs[0],cmdArgs[1]);
                    break;
                case "Analyze":
                    System.out.println(this.systemComponent.analyze());
                    break;

            }




            input=bufferedReader.readLine();
        }
    }


}
