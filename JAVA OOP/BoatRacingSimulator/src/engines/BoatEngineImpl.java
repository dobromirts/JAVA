package engines;

import interfaces.BoatEngine;

public abstract class BoatEngineImpl implements BoatEngine {
    private String model;
    private double outPut;
    private int horsePower;
    private double displacement;

    public BoatEngineImpl(String model,int horsePower, double displacement) {
        this.model=model;
        this.horsePower = horsePower;
        this.displacement = displacement;
        this.outPut=getOutput();
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getDisplacement() {
        return displacement;
    }


}
