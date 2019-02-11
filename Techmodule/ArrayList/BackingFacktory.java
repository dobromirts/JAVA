import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BackingFacktory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int bestQuality = 0;
        List<Integer> bestLocal = new ArrayList<>();
        double bestAverageQuality = 0;
        int maxLenght=0;

        while (!command.equals("Bake It!")) {
            List<Integer> baches = Arrays.stream(command.split("#")).map(Integer::parseInt).collect(Collectors.toList());
            int sum = 0;
            int Lenght=0;


            for (int i = 0; i < baches.size(); i++) {
                sum += baches.get(i);
            }
            double averageQual = (double)sum/ (double) baches.size() ;
            if (sum > bestQuality) {
                bestQuality = sum;
                bestLocal.removeAll(bestLocal);
                bestLocal.addAll(baches);
                bestAverageQuality = averageQual;
            } else if (sum == bestQuality) {
                if (averageQual > bestAverageQuality) {
                    bestAverageQuality = averageQual;
                    bestQuality = sum;
                    bestLocal.removeAll(bestLocal);
                    bestLocal.addAll(baches);
                }
            }else {

            }
            command = scanner.nextLine();

        }
        System.out.printf("Best Batch quality: %d%n", bestQuality);
        bestLocal.forEach(e -> System.out.print(e + " "));
    }
}
