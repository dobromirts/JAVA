package builder;

public class CreateBoatEngine {
    private String model;
    private double horsepower;
    private double displacement;
    private String type;

    //Builder pattern


    public CreateBoatEngine withModel(String model){
        this.model=model;
        return this;
    }
    public CreateBoatEngine withHorsepower(int horsepower){
        this.horsepower=horsepower;
        return this;
    }
}
