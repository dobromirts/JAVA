package callofduty;

import callofduty.core.Engine;
import callofduty.core.MissionControlImpl;
import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MissionControl missionControl=new MissionControlImpl();
        MissionManager missionManager=new MissionManagerImpl(missionControl);
        Engine engine=new Engine(missionManager);
        engine.run();
    }
}




