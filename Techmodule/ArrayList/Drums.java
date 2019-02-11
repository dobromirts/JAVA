import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Drums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = Double.parseDouble(sc.nextLine());

        List<Integer> drums = Arrays
                .stream(sc.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Double> prices = drums.stream().map(e -> e * 3d).collect(Collectors.toList());

        String line = sc.nextLine();

        while (!line.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(line);
            for (int i = 0; i < drums.size(); i++) {
                if (drums.get(i) == Integer.MIN_VALUE) {
                    continue;
                }
                drums.set(i, drums.get(i) - power);
                if (drums.get(i) <= 0) {
                    double price = prices.get(i);
                    if (money >= price) {
                        money -= price;
                        drums.set(i, (int)price/3);
                    } else {
                        drums.set(i, Integer.MIN_VALUE);
                    }
                }
            }

            line = sc.nextLine();
        }
        drums.stream()
                .filter(e -> e != Integer.MIN_VALUE)//Vajnop filtrirane
                .forEach(d -> System.out.print(d + " "));
        System.out.printf("%nGabsy has %.2flv.", money);
    }
}

