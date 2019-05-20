package models.components;

public class PowerHardware extends Hardware {
    private static final double DECREASE_MAXIMUM_CAPACITY=0.75;
    private static final double INCREASE_MAXIMUM_MEMORY=0.75;
    private static final String TYPE="Power";


    public PowerHardware(String name,  int maximumCapacity, int maximumMemory) {
        super(name, TYPE, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity-((int)(maximumCapacity*DECREASE_MAXIMUM_CAPACITY)));
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory+((int)(maximumMemory*INCREASE_MAXIMUM_MEMORY)));
    }
}
