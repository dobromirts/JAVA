import java.util.Scanner;

public class DungeonDark {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int health=100;
        int coins=0;
        int counter=0;
        String input=scanner.nextLine();

        String[] rooms = input.split("\\|+");

        for (int i = 0; i <rooms.length ; i++) {
            counter++;
            String currentRoom=rooms[i];
            String[]tokens=currentRoom.split(" ");
            String firstPart=tokens[0];
            int secondPart=Integer.parseInt(tokens[1]);

            if (firstPart.equals("potion")){
                int additionalHealth=secondPart;
                if (health<=(100-additionalHealth)){
                    health+=additionalHealth;
                    System.out.printf("You healed for %d hp.%n",additionalHealth);
                }else {
                    health+=(100-health);
                    System.out.printf("You healed for %d hp.%n",(100-health));
                }
                System.out.printf("Current health: %d hp.%n",health);
            }else if (firstPart.equals("chest")){
                int additionalCons=secondPart;
                coins+=additionalCons;
                System.out.printf("You found %d coins.%n",additionalCons);
            }else {
                int attackMonster=secondPart;
                health-=attackMonster;
                if (health>0){
                    System.out.printf("You slayed %s.%n",firstPart);
                }else {
                    System.out.printf("You died! Killed by %s.%n",firstPart);
                    System.out.printf("Best room: %d%n",counter);
                    return;
                }
            }

        }
        System.out.printf("You've made it!%nCoins: %d%nHealth: %d",coins,health);
    }
}
//int energyGained = Integer.parseInt(currentEvent[1]);
//                    if (energy <= (100 - energyGained)) {
//                        energy += energyGained;
//                        System.out.printf("You gained %d energy.%n", energyGained);
//                    } else {
//                        energy += (100 - energy);
//                        System.out.printf("You gained %d energy.%n", (100 - energy));
//                    }
//                    System.out.printf("Current energy: %d.%n", energy);
//                    break;