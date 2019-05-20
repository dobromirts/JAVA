package vechicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vechicle {

    private final int tackCapacity;
    private double fuelQuantity;
    private double fuelConsumption;


    public VehicleImpl(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.tackCapacity = tankCapacity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    @Override
    public String drive(double distance) {
        double fuelNeed = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");

        String result = "needs refueling";

        if (this.fuelQuantity >= fuelNeed) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeed;
        }
        return result;
    }

    @Override
    public void refuel(double liters) {
        if (liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (liters>tackCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;


    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
