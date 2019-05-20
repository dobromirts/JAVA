package boats;

import interfaces.BoatEngine;

public abstract class MotorBoat extends BoatImpl {
    private BoatEngine engine;

    public MotorBoat(String model, double weight, BoatEngine engine) {
        super(model, weight);
        this.engine=engine;
    }

    public BoatEngine getEngine() {
        return engine;
    }

    public void setEngine(BoatEngine engine) {
        this.engine = engine;
    }
}
