import java.security.InvalidParameterException;

public class Topping {

    private static final double MEAT=1.2;
    private static final double VEGGIES=0.8;
    private static final double CHEESE=1.1;
    private static final double SAUCE=0.9;


    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat")|| (toppingType.equals("Veggies")) || toppingType.equals("Cheese")|| toppingType.equals("Sauce")){
            this.toppingType=toppingType;
        }else {
            throw new InvalidParameterException("Cannot place "+toppingType+" on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight<1 || weight>50){
            throw new InvalidParameterException(this.toppingType+" weight should be in the range [1..50].");
        }
        this.weight=weight;
    }

    public double calculateCalories(){
        return calculatePizzaCalories(toppingType,weight);
    }

    private double calculatePizzaCalories(String toppingType,double weight) {
        double result=0;
        switch (toppingType){
            case "Meat":
                result=Topping.MEAT;
                break;
            case "Veggies":
                result=Topping.VEGGIES;
                break;
            case "Cheese":
                result=Topping.CHEESE;
                break;
            case "Sauce":
                result=Topping.SAUCE;
                break;
        }

        return result*=2*weight;
    }
}
