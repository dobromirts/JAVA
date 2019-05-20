package militaryElite.models;

import militaryElite.common.Mission;

import java.util.HashSet;

public class Commando extends SpecialisedSoldier {
    HashSet<Mission>missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        missions=new HashSet<>();
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Missions:").append(System.lineSeparator());

        for (Mission mission : missions) {
            sb.append(mission.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
