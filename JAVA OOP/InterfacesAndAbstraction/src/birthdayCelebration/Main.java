package birthdayCelebration;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();
        List<Birthable> birthables=new ArrayList<>();

        while (!input.equals("End")){
            String[]tokens=input.split(" ");
            String type=tokens[0];
            switch (type){
                case "Citizen":
                    Citizen citizen=new Citizen(
                            tokens[1],
                            Integer.parseInt(tokens[2]),
                            tokens[3],
                            tokens[4]);
                    birthables.add(citizen);

                    break;
                case "Pet":
                    Pet pet=new Pet(tokens[1],tokens[2]);
                    birthables.add(pet);
                    break;
            }
            input=scanner.nextLine();
        }
        String currentYear=scanner.nextLine();

        for (Birthable birthable : birthables) {
            String creatureBirthDate=birthable.getBirthDate();
            String creatureBirthYear=creatureBirthDate.split("/")[2];
            if (creatureBirthYear.equals(currentYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
