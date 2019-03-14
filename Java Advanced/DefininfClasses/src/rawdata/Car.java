package rawdata;

import java.util.ArrayList;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private ArrayList<Tire>tires;

    public Car(String model, Engine engine, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new ArrayList<>();
    }

    public ArrayList<Tire> getTires() {
        return tires;
    }


    public Double getAveregePressure(){
        return tires.stream().mapToDouble(tire->tire.getPresure()).average().getAsDouble();
    }
    public String getCargoType(){
        return this.cargo.getCargoType();
    }
    public String getModel(){
        return this.model;
    }
    public int getEnginePower(){
        return engine.getEnginePower();
    }


    @Override
    public String toString() {
        return String.format(getModel());
    }
}
