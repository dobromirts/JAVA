package pokemontrainer;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Tournament")) {

            String[] parets = line.split("\\s+");

            String trainerName = parets[0];

            Pokemon pokemon = new Pokemon(parets[1], parets[2], Integer.parseInt(parets[3]));

            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).getPokemons().add(pokemon);
            } else {
                Trainer trainer = new Trainer(trainerName);
                trainer.getPokemons().add(pokemon);

                trainers.put(trainerName, trainer);
            }

            line = scanner.nextLine();
        }


        String element = scanner.nextLine();

        while (!element.equals("End")) {
            String elementType = element;

            for (Trainer currentTrainer : trainers.values()) {
                if (currentTrainer.containsElement(elementType)){
                    currentTrainer.setBadges(currentTrainer.getBadges()+1);
                }else {
                    currentTrainer.decreaseHealth();
                    currentTrainer.removeDeadPokemons();
                }


            }

            element = scanner.nextLine();
        }
        System.out.println();

        trainers.entrySet().stream().sorted((e1,e2)->{
            int firstBadges=e1.getValue().getBadges();
            int secondBadges=e2.getValue().getBadges();
            return Integer.compare(secondBadges,firstBadges);
        }).forEach(enty->{
            Trainer tr=enty.getValue();
            System.out.print(tr);
        });


//        for (Trainer trainer : trainers.values()) {
//            System.out.printf("%s %d %d%n",trainer.getName(),trainer.getBadges(),trainer.getPokemons().size());
//        }


    }


}





