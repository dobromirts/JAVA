package wildFarm;

public class Tiger extends Felime {

    public Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    public void eatFood(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")){
            System.out.println(super.getAnimalType() + "s are not eating that type of food!");
        }else {
            setFoodEaten(food.getFoodQuantity());
        }
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
