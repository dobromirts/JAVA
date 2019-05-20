package race;

import boats.MotorBoat;
import exeptions.ArgumentExeption;
import exeptions.DuplicateModelExeption;
import interfaces.Boat;

import java.util.HashSet;
import java.util.Set;

public class Race {
    private  double distance;
    private double windSpeed;
    private double oceanCurrentSpeed;
    private Set<Boat> participants;
    private boolean allowMotorBoats;

    public Race(double distance, double windSpeed, double oceanCurrentSpeed, boolean allowMotorBoats) {
        this.distance = distance;
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.participants = new HashSet<>();
        this.allowMotorBoats = allowMotorBoats;
    }

    public void addParticipant(Boat participant) throws DuplicateModelExeption, ArgumentExeption {
        if (!this.isAllowMotorBoats()&& participant instanceof MotorBoat){
            throw new ArgumentExeption();
        }


        boolean added=participants.add(participant);

        if (!added){
            throw new DuplicateModelExeption();
        }
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    public void setOceanCurrentSpeed(double oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public Set<Boat> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Boat> participants) {
        this.participants = participants;
    }

    public boolean isAllowMotorBoats() {
        return allowMotorBoats;
    }

    public void setAllowMotorBoats(boolean allowMotorBoats) {
        this.allowMotorBoats = allowMotorBoats;
    }
}
