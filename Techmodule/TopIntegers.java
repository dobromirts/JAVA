import java.util.Scanner;

public class TopIntegers{

    public static boolean isDivisible(int fromIndex) {
        int sum = 0;

        boolean isDivisible = false;

        while (fromIndex > 0) {

            int lastDigit = fromIndex % 10;
            sum += lastDigit;
            fromIndex /= 10;
        }
        if (sum % 8 == 0) {
            isDivisible = true;
        }


        return isDivisible;
    }

    public static boolean containsOddDigit(int fromIndex) {

        boolean isContainOdd = false;
        while (fromIndex > 0) {
            int lastDigit = fromIndex % 10;

            if (lastDigit % 2 == 1) {
                isContainOdd = true;

                break;
            }
            fromIndex /= 10;
        }
        return isContainOdd;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i <= num; i++) {
            if (isDivisible(i) && containsOddDigit(i)) {
                System.out.println(i);
            }
        }


    }


}