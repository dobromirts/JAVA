package wildFarm;

public abstract class AnimalImpl implements Animal{
    private String animalType;
    private String animalName;
    private double animalWeight;
    private int foodEaten;



    public AnimalImpl(String animalType, String animalName, double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten=0;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten += foodEaten;
    }

    protected int getFoodEaten() {
        return foodEaten;
    }

    protected String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }
}
