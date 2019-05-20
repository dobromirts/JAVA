package callofduty.domain;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;


public abstract class AgentImpl implements Agent {
    private static final double INITIAL_RATING=0;

    private String id;
    private String name;
    private double rating;
    private List<Mission>acceptedMissions;
    private List<Mission>completedMissions;

    public AgentImpl(String id, String name) {
        this.setId(id);
        this.name = name;
        this.rating=INITIAL_RATING;
        this.completedMissions=new ArrayList<>();
        this.acceptedMissions=new ArrayList<>();
    }


    protected void setId(String id) {
        this.id = id;
    }

    protected void setRating(double rating) {
        this.rating = rating;
    }





    @Override
    public void acceptMission(Mission mission) {
        this.acceptedMissions.add(mission);
    }

    @Override
    public void completeMissions() {
        completedMissions.addAll(acceptedMissions);
        acceptedMissions.clear();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        ////Assigned Missions: 3
        //        //Completed Missions: 0
        ////Rating: 0,00

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Assigned Missions: ").append(acceptedMissions.size()).append(System.lineSeparator());
        stringBuilder.append("Completed Missions: ").append(completedMissions.size()).append(System.lineSeparator());
        stringBuilder.append("Rating: ").append(this.rating).append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
