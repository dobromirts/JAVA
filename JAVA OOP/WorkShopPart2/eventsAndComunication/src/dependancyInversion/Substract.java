package dependancyInversion;

public class Substract implements Operation {
    @Override
    public int execute(int first, int second) {
        return first-second;
    }
}
