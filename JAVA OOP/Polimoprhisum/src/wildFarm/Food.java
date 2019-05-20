package wildFarm;

public abstract class Food {
    private int foodQuantity;

    public Food(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }
}
