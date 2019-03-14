package softUniParking;

import java.util.HashMap;
import java.util.List;

public class Parking {
    //•	cars – Map<String, Car>
    //•	capacity - accessed only by the base class (responsible for the parking capacity).

    private HashMap<String,Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car){
        if (this.cars.containsKey(car.getRegistrationNumber())){
           return "Car with that registration number, already exists!";
        }else if (this.cars.size()>=this.capacity){
            return "Parking is full!";
        }
        cars.putIfAbsent(car.getRegistrationNumber(),car);
        return String.format("Successfully added new car %s %s",car.getMake(),car.getRegistrationNumber());
    }


    public String removeCar(String registrationNumber){
        if (!this.cars.containsKey(registrationNumber)){
            return "Car with that registration number, doesn't exists!";
        }
        cars.remove(registrationNumber);
        return "Successfully removed "+ registrationNumber;
    }


    public Car getCar(String registrationNumber){
        return cars.get(registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String registrationNumber : registrationNumbers) {
            this.removeCar(registrationNumber);
        }
    }

    public int getCount(){
        return this.cars.size();
    }
}
