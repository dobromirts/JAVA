package model.boat;

import model.race.Conditions;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, double weight, int sailEfficiency) {
        super(model, weight);
        this.sailEfficiency = sailEfficiency;
    }

    public int getSailEfficiency() {
        return sailEfficiency;
    }

    public void setSailEfficiency(int sailEfficiency) {
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return (conditions.getWindSpeed()* (this.getSailEfficiency() / 100.0))
                - this.getWeight() + conditions.getCurrentSpeed() / 2;
    }
}
