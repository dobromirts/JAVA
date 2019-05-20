package callofduty.core;

import callofduty.domain.agents.NoviceAgent;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {
    private MissionControl missionControl;
    private Map<String, Agent>agentsById;


    public MissionManagerImpl(MissionControl missionControl) {
        this.missionControl = missionControl;
        this.agentsById=new HashMap<>();
    }

    @Override
    public String agent(List<String> arguments) {
        Agent agent=new NoviceAgent(arguments.get(0),arguments.get(1));
        agentsById.putIfAbsent(agent.getId(),agent);


        return String.format("Registered Agent - %s:%s",agent.getName(),agent.getId());
    }

    @Override
    public String request(List<String> arguments) {
            String agentId = arguments.get(0);
            String missionId = arguments.get(1);
            Double missionRating = Double.parseDouble(arguments.get(2));
            Double missionBounty = Double.parseDouble(arguments.get(3));

            Agent agent = this.agentsById.get(agentId);
            Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);

            agent.acceptMission(mission);
        return String.format("Assigned %s Mission - %s to Agent - %s",mission.getClass()
                .getSimpleName()
                .replace("Mission",""),mission.getId(),agent.getName());
    }

    @Override
    public String complete(List<String> arguments) throws NoSuchFieldException {
        String agentId=arguments.get(0);
        Agent agent=agentsById.get(agentId);
        //Novice Agent - Donald
        //Personal Code: 007b
        //Assigned Missions: 3
        //Completed Missions: 0
        //Rating: 0,00



        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(agent.getClass().getSimpleName()).append(" - ").append(agent.getName()).append(System.lineSeparator());
        stringBuilder.append("Personal Code: ").append(agent.getId()).append(System.lineSeparator());
        stringBuilder.append(agent.toString());
        return stringBuilder.toString();
    }

    @Override
    public String status(List<String> arguments) {
        return null;
    }

    @Override
    public String over(List<String> arguments) {
        return null;
    }
}
