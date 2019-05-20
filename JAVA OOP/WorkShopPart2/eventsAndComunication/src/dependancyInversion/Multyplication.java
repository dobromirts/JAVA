package dependancyInversion;

public class Multyplication implements Operation {
    @Override
    public int execute(int first, int second) {
        return first*second;
    }
}
