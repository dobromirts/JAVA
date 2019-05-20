package vechicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInformation = scanner.nextLine().split("\\s+");
        String[] truckInformation = scanner.nextLine().split("\\s+");
        String[] busInformation = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInformation[1]), Double.parseDouble(carInformation[2]), Integer.parseInt(carInformation[3]));
        Truck truck = new Truck(Double.parseDouble(truckInformation[1]), Double.parseDouble(truckInformation[2]), Integer.parseInt(truckInformation[3]));
        Bus bus = new Bus(Double.parseDouble(busInformation[1]), Double.parseDouble(busInformation[2]), Integer.parseInt(busInformation[3]));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] currentCommand = scanner.nextLine().split("\\s+");
            try {
                switch (currentCommand[0]) {

                    case "Drive":
                        if (currentCommand[1].equals("Car")) {
                            System.out.println(car.drive(Double.parseDouble(currentCommand[2])));
                        } else if (currentCommand[1].equals("Bus")) {
                            System.out.println(bus.drive(Double.parseDouble(currentCommand[2])));
                        } else {
                            System.out.println(truck.drive(Double.parseDouble(currentCommand[2])));
                        }
                        break;
                    case "Refuel":
                        if (currentCommand[1].equals("Car")) {
                            car.refuel(Double.parseDouble(currentCommand[2]));
                        } else if (currentCommand[1].equals("Bus")) {
                            bus.refuel(Double.parseDouble(currentCommand[2]));
                        } else {
                            truck.refuel(Double.parseDouble(currentCommand[2]));
                        }
                        break;
                    case "DriveEmpty":
                        bus.setFuelConsumptionEmptyBus(Double.parseDouble(busInformation[2]));
                        System.out.println(bus.drive(Double.parseDouble(currentCommand[2])));
                        break;
                }
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
