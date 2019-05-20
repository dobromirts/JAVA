package models.components;

import java.util.List;

public class HeavyHardware extends Hardware {
    private static final double DECREASE_MAXIMUM_MEMORY=0.25;
    private static final int INCREASE_MAXIMUM_CAPACITY=2;
    private static final String TYPE="Heavy";
    public HeavyHardware(String name,int maximumCapacity, int maximumMemory) {
        super(name, TYPE, maximumCapacity, maximumMemory);
    }



    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity*INCREASE_MAXIMUM_CAPACITY);
    }
    @Override
    public void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory-(int)(maximumMemory*DECREASE_MAXIMUM_MEMORY));
    }


}
