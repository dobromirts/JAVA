import java.util.Scanner;

public class Backing {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        int student=Integer.parseInt(scanner.nextLine());
        double priceOfFlour=Double.parseDouble(scanner.nextLine());
        double priceOfSingleEgg=Double.parseDouble(scanner.nextLine());
        double priceOfApron=Double.parseDouble(scanner.nextLine());


        double arpons=0;

        int count=0;
        double priceOfallEgss=0;
        double priceOfFl=0;



        double stRounded=Math.ceil(student+(student*0.2));
        double allArponsPrice=priceOfApron*stRounded;





        for (int i = 0; i <student ; i++) {
            priceOfallEgss+=(10*priceOfSingleEgg);
            priceOfFl+=priceOfFlour;
            count++;
            if (count%5==0){
                priceOfFl-=priceOfFlour;
            }

        }
        double sum=priceOfFl+priceOfallEgss+allArponsPrice;
        double resut=Math.abs(budget-sum);
        if (sum<=budget){
            System.out.printf("Items purchased for %.2f$.",sum);
        }else if (sum>budget){
            System.out.printf("%.2f$ more needed.",resut);
        }







    }
}
