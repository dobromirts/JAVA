package boats;

import interfaces.BoatEngine;

public class PowerBoat extends MotorBoat {
    private BoatEngine second;


    public PowerBoat(String model, double weight, BoatEngine engine,BoatEngine right) {
        super(model, weight, engine);
        this.second =right;
    }
}
