package boats;

import interfaces.Boat;

import java.util.Objects;

public abstract class BoatImpl implements Boat {
    private String model;
    private double weight;

    public BoatImpl(String model, double weight) {
        this.model = model;
        this.weight = weight;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boat)) return false;
        BoatImpl boat = (BoatImpl) o;
        return Objects.equals(model, boat.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
