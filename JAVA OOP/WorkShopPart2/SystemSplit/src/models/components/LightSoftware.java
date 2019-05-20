package models.components;

public class LightSoftware extends Software {
    private static final double DECREASE_MEMORY_CONSUMPTION = 0.5;
    private static final double INCREASE_CAPACITY_CONSUMPTION = 0.5;
    private static final String TYPE="Light";

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - (int) (memoryConsumption * DECREASE_MEMORY_CONSUMPTION));
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption+(int)(capacityConsumption*INCREASE_CAPACITY_CONSUMPTION));
    }


}
