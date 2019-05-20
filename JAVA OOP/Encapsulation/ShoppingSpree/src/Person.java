import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Person {
    private String name;
    private double money;
    private List<Product>products;

    public Person(String name, double money ){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name=name;
    }

    public void setMoney(double money) {
        if (money<0){
            throw new InvalidParameterException("Money cannot be negative");
        }
        this.money=money;
    }

    public void buyProduct(Product product){
        if (this.money<product.getCost()){
            System.out.printf("%s can't afford %s.%n",this.name,product.getName());
        }else {
            System.out.printf("%s bought %s%n",this.name,product.getName());
            products.add(product);
            this.money-=product.getCost();
        }
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void forEach(Consumer<Product>productConsumer){
        for (Product product : products) {
            productConsumer.accept(product);
        }
    }
}
