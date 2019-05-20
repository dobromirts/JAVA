package builder;

public class CreateBoatEngine {
    private String model;
    private double horsepower;
    private double displacement;
    private String type;

    public CreateBoatEngine withModel(String model) {
        this.model = model;

        return this;
    }

    public CreateBoatEngine withHorsepower(double horsepower) {
        this.horsepower = horsepower;

        return this;
    }
}
