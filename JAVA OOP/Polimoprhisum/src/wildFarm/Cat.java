package wildFarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion,String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed=breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder(super.toString());
        stringBuilder.insert(super.toString().indexOf(",")+1," "+this.breed+",");
        return stringBuilder.toString();
    }
}
