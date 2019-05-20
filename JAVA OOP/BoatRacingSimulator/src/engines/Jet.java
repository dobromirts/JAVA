package engines;

public class Jet extends BoatEngineImpl {
    public Jet(String model, int horsePower, double displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    public double getOutput() {
        return (this.getHorsePower()*5)+this.getDisplacement();
    }
}
