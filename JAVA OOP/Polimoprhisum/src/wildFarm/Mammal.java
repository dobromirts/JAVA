package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends AnimalImpl {
     protected String livingRegion;

    public Mammal(String animalType, String animalName, double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion=livingRegion;
    }

    @Override
    public void eatFood(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")){
            String animalType=this.getAnimalType().equals("Mouse")?"Mice" : "Zebras";
            System.out.println(animalType + " are not eating that type of food!");
        }else {
            super.setFoodEaten(food.getFoodQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat=new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]",getAnimalType(),getAnimalName(),
                decimalFormat.format(getAnimalWeight()),this.livingRegion,getFoodEaten());
    }
}
