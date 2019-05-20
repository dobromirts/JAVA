package militaryElite.models;

import militaryElite.common.Repair;

import java.util.HashSet;

public class Engineer extends SpecialisedSoldier {
    HashSet<Repair>repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs=new HashSet<>();
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Repairs:").append(System.lineSeparator());

        for (Repair repair : repairs) {
            sb.append(repair.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }




}
