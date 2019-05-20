import java.security.InvalidParameterException;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name=name;
    }

    private void setCost(double cost) {
        if (cost<0){
            throw new InvalidParameterException("Money cannot be negative");
        }
        this.cost=cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
