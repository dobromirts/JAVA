package model.boat;

import model.engine.Engine;
import model.race.Conditions;

public class Yacht extends Motorboat {
    private double cargo;

    public Yacht(String model, double weight, Engine engine, double cargo) {
        super(model, weight, engine);
        this.cargo = cargo;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return this.getEngine().getOutput() - this.getWeight() +
                this.getCargo() + (conditions.getCurrentSpeed() / 2);
    }
}
