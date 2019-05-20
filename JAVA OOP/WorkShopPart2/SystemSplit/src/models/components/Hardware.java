package models.components;

import java.util.*;

public abstract class Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private Map<String,Software> softwares;
    private int capacityUsed;
    private int memoryUsed;

    public Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwares=new LinkedHashMap<>();
        this.capacityUsed=0;
        this.memoryUsed=0;
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

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }



    private boolean hasFreeCapacity(int capacity){
        return (this.maximumCapacity-(this.capacityUsed+capacity))>=0;
    }
    private boolean hasFreeMemomry(int memory){
        return (this.maximumMemory-(this.memoryUsed+memory))>=0;
    }

    public void addSoftware(Software software){
        if (this.hasFreeCapacity(software.getCapacityConsumption())&& this.hasFreeMemomry(software.getMemoryConsumption())){
            this.softwares.putIfAbsent(software.getName(),software);
            this.capacityUsed+=software.getCapacityConsumption();
            this.memoryUsed+=software.getMemoryConsumption();
        }
    }

    public void releaseSoftware(String softwareName) {
        Software software=this.softwares.get(softwareName);
        if (this.softwares.containsKey(softwareName)) {
            softwares.remove(softwareName);
            this.capacityUsed -= software.getCapacityConsumption();
            this.memoryUsed -= software.getMemoryConsumption();
        }
    }

    public int getSoftwareComponentsCount(){
        return this.softwares.size();
    }

    public int getUsedCapacity(){
        return this.capacityUsed;
    }

    public Map<String, Software> getSoftwares() {
        return softwares;
    }

    public int getCapacityUsed() {
        return capacityUsed;
    }

    public int getMemoryUsed() {
        return memoryUsed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();

        int expressCount=(int)this.softwares.keySet().stream().filter(k->this.softwares.get(k).getType().equals("Express"))
                .count();
        int lightCount=this.softwares.size()-expressCount;

        stringBuilder.append("Hardware Component: ").append(this.getName()).append(System.lineSeparator())
                .append("Express Software Components - ").append(expressCount).append(System.lineSeparator())
                .append("Light Software Components - ").append(lightCount).append(System.lineSeparator())
                .append("Memory Usage: ").append(this.memoryUsed).append(" / ").append(this.maximumMemory)
                .append(System.lineSeparator())
                .append("Capacity Usage: ").append(this.capacityUsed).append(" / ").append(this.maximumCapacity)
                .append(System.lineSeparator())
                .append("Type: ").append(this.getType()).append(System.lineSeparator());


        return stringBuilder.toString();
    }
}
