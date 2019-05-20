package model.boat;

import model.engine.Engine;
import model.race.Conditions;

public class PowerBoat extends Motorboat {
    private Engine secondEngine;

    public PowerBoat(String model, double weight, Engine engine, Engine secondEngine) {
        super(model, weight, engine);
        this.secondEngine = secondEngine;
    }

    public Engine getSecondEngine() {
        return secondEngine;
    }

    public void setSecondEngine(Engine secondEngine) {
        this.secondEngine = secondEngine;
    }

    @Override
    public double getSpeed(Conditions conditions) {
        return this.getEngine().getOutput() + this.getSecondEngine().getOutput() -
                this.getWeight() + (conditions.getCurrentSpeed() / 5);
    }
}
