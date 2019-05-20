package boats;

import interfaces.BoatEngine;

public class Yacht extends MotorBoat {

    private double cargoWeight;


    public Yacht(String model, double weight, BoatEngine engine,double cargoWeight) {
        super(model, weight, engine);
        this.cargoWeight=cargoWeight;
    }
}
