import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Quest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String>begginerQuests= Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        String input=scanner.nextLine();

        while (!input.equals("Retire!")){
            String[]comArgs=input.split("-\\s+");
            String command=comArgs[0];
            String currentQuest=comArgs[1];

            if (command.equals("Start ")){
//                if (begginerQuests.contains(currentQuest)){
//                    continue;
//                }
                begginerQuests.add(currentQuest);
            }else if (command.equals("Complete ")){
                if (begginerQuests.contains(currentQuest)){
                    int indexOfCurrent=begginerQuests.indexOf(currentQuest);
                    begginerQuests.remove(indexOfCurrent);
                }
            }else if (command.equals("Side Quest ")){
                String[]modif=currentQuest.split(":");
                String quest=modif[0];
                String sub=modif[1];
                if (begginerQuests.contains(quest)){
                    if (begginerQuests.contains(sub)){
                        continue;
                    }else {
                        int indexOfQ=begginerQuests.indexOf(quest);
                        begginerQuests.add(indexOfQ+1,sub);
                    }
                }


            }else if (command.equals("Renew ")){
                if (begginerQuests.contains(currentQuest)){
                    int indexOfTemp=begginerQuests.indexOf(currentQuest);
                    String temp=begginerQuests.get(indexOfTemp);
                    begginerQuests.remove(indexOfTemp);
                    begginerQuests.add(temp);
                }
            }





            input=scanner.nextLine();
        }
        for (int i = 0; i <begginerQuests.size()-1 ; i++) {
            System.out.print(begginerQuests.get(i)+","+" ");
        }
        System.out.print(begginerQuests.get(begginerQuests.size()-1));
    }
}
