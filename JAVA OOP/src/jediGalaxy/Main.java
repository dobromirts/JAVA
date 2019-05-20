package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Galaxy galaxy=new Galaxy(dimestions[0],dimestions[1]);
            StarsManipulator starsManipulator =new StarsManipulator(galaxy);

            long sum=0;

            String input=scanner.nextLine();

            while (!input.equals("Let the Force be with you")){

                int[]playerPositions= Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[]enemyPossitions= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


                starsManipulator.destroyStars(enemyPossitions);
                sum+=starsManipulator.collectStars(playerPositions);

                input=scanner.nextLine();
            }

        System.out.println(sum);

    }
}
