package wildFarm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<Animal>animals=new ArrayList<>();
        ArrayList<Food>foods=new ArrayList<>();

        while (!input.equals("End")) {
            String[] animalInformation = input.split("\\s+");
            String[] foodInformation = scanner.nextLine().split("\\s+");


            Animal animal=null;
            Food food=null;
            switch (foodInformation[0]) {
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodInformation[1]));
                    foods.add(food);
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodInformation[1]));
                    foods.add(food);
                    break;

            }
            switch (animalInformation[0]) {
                case "Cat":
                    Animal cat= new Cat(animalInformation[0], animalInformation[1],
                            Double.parseDouble(animalInformation[2]), animalInformation[3], animalInformation[4]);
                    animals.add(cat);

                    break;
                case "Mouse":
                    Animal mouse = new Mouse(animalInformation[0], animalInformation[1],
                            Double.parseDouble(animalInformation[2]), animalInformation[3]);
                    animals.add(mouse);
                    break;
                case "Zebra":
                    Animal zebra = new Zebra(animalInformation[0], animalInformation[1],
                            Double.parseDouble(animalInformation[2]), animalInformation[3]);
                    animals.add(zebra);
                    break;
                case "Tiger":
                    Animal tiger = new Tiger(animalInformation[0], animalInformation[1],
                            Double.parseDouble(animalInformation[2]), animalInformation[3]);
                    animals.add(tiger);
                    break;
            }
            
            input = scanner.nextLine();
        }


        for (int i = 0; i <animals.size() ; i++) {
            animals.get(i).makeSound();
            animals.get(i).eatFood(foods.get(i));
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
