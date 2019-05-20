package models.components;

public abstract class Software {
    private String name;
    private String type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.type = type;
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    protected   void setCapacityConsumption(int capacityConsumption){
        this.capacityConsumption=capacityConsumption;
    }
    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
