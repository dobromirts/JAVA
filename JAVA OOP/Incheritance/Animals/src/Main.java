import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();

        while (!input.equals("Beast!")){
            String []animalParameters=scanner.nextLine().split(" ");

            try {
                switch (input){
                    case "Dog":
                        Dog dog=new Dog(animalParameters[0],Integer.parseInt(animalParameters[1]),animalParameters[2]);
                        System.out.println(dog.getClass().getName());
                        System.out.println(animalParameters[0] + " "+ animalParameters[1]+ " " +animalParameters[2]);
                        System.out.println(dog.produceSound());

                        break;
                    case "Cat":
                        Cat cat=new Cat(animalParameters[0],Integer.parseInt(animalParameters[1]),animalParameters[2]);
                        System.out.println(cat.getClass().getName());
                        System.out.println(animalParameters[0] + " "+ animalParameters[1]+ " " +animalParameters[2]);
                        System.out.println(cat.produceSound());
                        break;
                    case "Frog":
                        Frog frog=new Frog(animalParameters[0],Integer.parseInt(animalParameters[1]),animalParameters[2]);
                        System.out.println(frog.getClass().getName());
                        System.out.println(animalParameters[0] + " "+ animalParameters[1]+ " " +animalParameters[2]);
                        System.out.println(frog.produceSound());
                        break;
                    case "Kitten":
                        Kitten kitten=new Kitten(animalParameters[0],Integer.parseInt(animalParameters[1]),animalParameters[2]);
                        System.out.println(kitten.getClass().getName());
                        System.out.println(animalParameters[0] + " "+ animalParameters[1]+ " " +animalParameters[2]);
                        System.out.println(kitten.produceSound());
                        break;
                    case "Tomcat":
                        Tomcat tomcat=new Tomcat(animalParameters[0],Integer.parseInt(animalParameters[1]),animalParameters[2]);
                        System.out.println(tomcat.getClass().getName());
                        System.out.println(animalParameters[0] + " "+ animalParameters[1]+ " " +animalParameters[2]);
                        System.out.println(tomcat.produceSound());
                        break;
                }

            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            input=scanner.nextLine();
        }


    }
}
