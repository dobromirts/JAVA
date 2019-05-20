import java.security.InvalidParameterException;

public class Dough {


    private static final double WHITE = 1.5;
    private static final double WHOLEGRAIN = 1.5;

    private static final double CRISPY = 1.5;
    private static final double CHEWY = 1.5;
    private static final double HOMEMADE = 1.5;


    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                this.flourType = flourType;
                break;
            case "Wholegrain":
                this.flourType = flourType;
                break;
            default:
                throw new InvalidParameterException("Invalid type of dough");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bakingTechnique=bakingTechnique;
                break;
            case "Chewy":
                this.bakingTechnique=bakingTechnique;
                break;
            case "Homemade":
                this.bakingTechnique=bakingTechnique;
                break;
            default:
                throw new InvalidParameterException("Invalid type of dough");
        }
    }

    private void setWeight(double weight) {
        if (weight<1 || weight>200){
            throw new InvalidParameterException("Dough weight should be in the range [1..200].");
        }
        this.weight=weight;
    }

    public double calculateCalories() {
        return calculatePizzaCalories(flourType,bakingTechnique,weight);
    }

    private double calculatePizzaCalories(String flourType,String bakingTechnique,double weight){
        double result=0;

        switch (flourType){
            case "white":
                result=Dough.WHITE;
                break;
            case "wholegrain":
                result=Dough.WHOLEGRAIN;
                break;
        }

        switch (bakingTechnique){
            case "crispy":
                result*=Dough.CRISPY;
                break;
            case "chewy":
                result*=Dough.CHEWY;
                break;
            case "homemade":
                result*=Dough.HOMEMADE;
                break;
        }

        return result*=2*weight;
    }

}
