package model.boat;

import model.race.Conditions;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, double weight, int oars) {
        super(model, weight);
        this.oars = oars;
    }

    public int getOars() {
        return oars;
    }

    public void setOars(int oars) {
        this.oars = oars;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return this.getOars() * 100 - this.getWeight() + conditions.getCurrentSpeed();
    }
}
