package core;

import models.components.Hardware;
import models.components.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class SystemComponent {
    private Map<String, Hardware> hardwareComponents;

    public SystemComponent() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardware(Hardware hardware) {
        hardwareComponents.putIfAbsent(hardware.getName(), hardware);
    }

    public Map<String, Hardware> getHardwareComponents() {
        return hardwareComponents;
    }

    public void addSoftware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).releaseSoftware(softwareName);
        }
    }

    public String analyze() {
        String lineSeparator = System.lineSeparator();
        StringBuilder stringBuilder = new StringBuilder("System Analysis");
        stringBuilder.append(lineSeparator);

        stringBuilder.append("Hardware Components: ").append(this.hardwareComponents.size()).append(lineSeparator);

        int softwareComponents = 0;
        int memoryInUse = 0;
        int memoryTotal = 0;
        int capacityInUse = 0;
        int capacityTotal = 0;


        for (String name : hardwareComponents.keySet()) {
            softwareComponents += this.hardwareComponents.get(name).getSoftwareComponentsCount();
            memoryInUse += this.hardwareComponents.get(name).getMemoryUsed();
            memoryTotal += this.hardwareComponents.get(name).getMaximumMemory();
            capacityInUse += this.hardwareComponents.get(name).getCapacityUsed();
            capacityTotal += this.hardwareComponents.get(name).getMaximumCapacity();
        }

        stringBuilder.append("Software Components: ")
                .append(softwareComponents).append(lineSeparator)
                .append("Total operational Memory: ")
                .append(memoryInUse).append(" / ")
                .append(memoryTotal)
                .append(lineSeparator)
                .append("Total Capacity Taken: ")
                .append(capacityInUse).append(" / ")
                .append(capacityTotal);


        return stringBuilder.toString();

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Power")).forEach(e -> {
            stringBuilder.append(e.getValue().toString()).append(System.lineSeparator());
        });

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Heavy")).forEach(e -> {
            stringBuilder.append(e.getValue().toString()).append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }
}
