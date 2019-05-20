import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping>toppings;


    public Pizza(String name,int toppingCount) {
        this.setName(name);
        this.setToppings(toppingCount);
    }

    private void setToppings(int toppingsCount){
        if (toppingsCount<0 || toppingsCount>10){
            throw  new InvalidParameterException("Number of toppings should be in range [0..10].");
        }
        this.toppings=new ArrayList<>(toppingsCount);

    }
    private void setName (String name){
        if (name.trim().isEmpty() || name.length()>15){
            throw new InvalidParameterException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name=name;
    }

    public void setDough(Dough dough){
        this.dough=dough;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        double overallCalories= this.dough.calculateCalories();

        double toppingCalorries=0;

        for (Topping topping : toppings) {
            toppingCalorries+=topping.calculateCalories();
        }

        return overallCalories+toppingCalorries;
    }
}
