package model.race;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import model.boat.Boat;
import model.boat.Motorboat;

import java.util.HashSet;
import java.util.Set;

public class Race {
    private double distance;
    private Conditions conditions;

    private Set<Boat> participants;
    private boolean allowMotorboats;

    public Race(double distance, double windSpeed, double currentSpeed, boolean allowMotorboats) {
        this.distance = distance;
        this.conditions = new Conditions(windSpeed, currentSpeed);
        this.allowMotorboats = allowMotorboats;

        this.participants = new HashSet<>();
    }


    public void addParticipant(Boat newParticipant) throws DuplicateModelException, ArgumentException {
        if (!this.areMotorboatsAllowed() && newParticipant instanceof Motorboat) {
            throw new ArgumentException();
        }

        boolean added = this.participants.add(newParticipant);

        if (!added) throw new DuplicateModelException();
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Set<Boat> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Boat> participants) {
        this.participants = participants;
    }

    public boolean areMotorboatsAllowed() {
        return allowMotorboats;
    }

    public void setAllowMotorboats(boolean allowMotorboats) {
        this.allowMotorboats = allowMotorboats;
    }

    public boolean enoughParticipants() {
        return this.participants.size() > 2;
    }

    public Conditions getConditions() {
        return this.conditions;
    }
}
