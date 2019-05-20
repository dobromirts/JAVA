package boats;

public class SailBoat extends BoatImpl {
    private int sailEfficiency;
    public SailBoat(String model, double weight,int sailEfficiency) {
        super(model, weight);
        this.sailEfficiency=sailEfficiency;
    }
}
