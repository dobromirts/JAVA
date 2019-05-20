package wildFarm;

public abstract class Felime extends Mammal{

    public Felime(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }


    @Override
    public void eatFood(Food food) {
        super.setFoodEaten(food.getFoodQuantity());
    }
}
