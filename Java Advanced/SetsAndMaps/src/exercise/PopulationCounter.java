package exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationByPlaces = new LinkedHashMap<>();
        LinkedHashMap<String, Long> totalCountByCountry = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String town = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);

            if (!populationByPlaces.containsKey(country)) {
                totalCountByCountry.put(country, population);

                populationByPlaces.put(country, new LinkedHashMap<>());
                populationByPlaces.get(country).put(town, population);
            } else {
                if (!populationByPlaces.get(country).containsKey(town)) {
                    populationByPlaces.get(country).put(town, population);

                    totalCountByCountry.put(country, totalCountByCountry.get(country) + population);
                }

            }


            input = scanner.nextLine();
        }

        populationByPlaces.entrySet().stream().sorted((e1, e2) -> totalCountByCountry.get(e2.getKey()).compareTo(totalCountByCountry.get(e1.getKey())))
                .forEach(entry -> {
                    System.out.format("%s (total population: %d)%n", entry.getKey(), totalCountByCountry.get(entry.getKey()));

                    entry.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> {
                                System.out.format("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }
}
