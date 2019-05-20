package engines;

public class Sterndrive extends BoatEngineImpl {

    public Sterndrive(String model, int horsePower, double displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    public double getOutput() {
        return (this.getHorsePower()*7)+this.getDisplacement();
    }


}
