import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BackingFactory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        int bestQuality=0;
        double bestAverageQuality=0;
        int bestLenght=0;
        int count=0;

        List<Integer>total=new ArrayList<>();

        while (!input.equals("Bake It!")){
            count++;
            int[]numbers= Arrays.stream(input.split("\\#")).mapToInt(Integer::parseInt).toArray();

            int quality=0;

            for (int i = 0; i <numbers.length ; i++) {
                quality+=numbers[i];
            }
            double averageQuality=0;
            for (int i = 0; i <numbers.length ; i++) {
                averageQuality+=((double)numbers[i]/(double)numbers.length);
            }
            if (count==1){               //Vajna proerka   Dali ima samo 1 input
                bestQuality=quality;
                bestAverageQuality=averageQuality;
                bestLenght=numbers.length;

                for (int i = 0; i <numbers.length ; i++) {
                    total.add(i,numbers[i]);
                }
            }

            if (quality>bestQuality){
                if (total.size()>0){
                    total.removeAll(total);
                }
                bestQuality=quality;
                bestAverageQuality=averageQuality;
                bestLenght=numbers.length;
                for (int i = 0; i <numbers.length ; i++) {
                    total.add(i,numbers[i]);
                }
            }else if (quality==bestQuality);{
                if (averageQuality>bestAverageQuality){
                    if (total.size()>0){
                        total.removeAll(total);
                    }
                    for (int i = 0; i <numbers.length ; i++) {
                        total.add(i,numbers[i]);
                    }
                }else if (averageQuality==bestAverageQuality){
                    int lenth=numbers.length;

                    if (lenth<bestLenght){
                        if (total.size()>0){
                            total.removeAll(total);
                        }
                        for (int i = 0; i <numbers.length ; i++) {
                            total.add(i,numbers[i]);
                        }
                    }
                }
            }




            input=scanner.nextLine();
        }

        System.out.printf("Best Batch quality: %d%n",bestQuality);
        total.forEach(e-> System.out.print(e+ " "));
    }
}
