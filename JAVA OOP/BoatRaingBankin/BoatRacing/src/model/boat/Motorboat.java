package model.boat;

import model.engine.Engine;

public abstract class Motorboat extends Boat {
    private Engine engine;

    public Motorboat(String model, double weight, Engine engine) {
        super(model, weight);
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
