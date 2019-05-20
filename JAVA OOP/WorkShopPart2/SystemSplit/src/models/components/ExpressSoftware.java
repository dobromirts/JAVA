package models.components;

public class ExpressSoftware extends Software {
    private static final int DOUBLE_MAXIMUM_MEMORY_CONSUMPTION=2;
    private static final String TYPE="Express";
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE, capacityConsumption, memoryConsumption);
    }


    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption*DOUBLE_MAXIMUM_MEMORY_CONSUMPTION);
    }

}
