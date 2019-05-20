package boats;

public class RowBoat extends BoatImpl {
    private int oars;
    public RowBoat(String model, double weight,int oars) {
        super(model, weight);
        this.oars=oars;
    }


}
