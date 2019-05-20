package vechicles;

public class Bus extends VehicleImpl {
    public Bus(double fuelQuantity, double fuelConsumption,int tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }


    @Override
    protected void setFuelConsumption(double fuelConsumption) {

        super.setFuelConsumption(fuelConsumption+1.4);
    }

    protected void setFuelConsumptionEmptyBus(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption);
    }


    @Override
    public String drive(double distance) {
        return "Bus "+super.drive(distance);
    }




}
