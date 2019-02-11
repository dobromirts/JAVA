import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int companions=Integer.parseInt(scanner.nextLine());
        int days=Integer.parseInt(scanner.nextLine());

        int sumCoins=0;
        int count=0;

        for (int i = 0; i < days; i++) {
            count++;
            if (count%10==0){
                companions-=2;
            }
            if (count%15==0){
                companions+=5;
            }
            sumCoins+=50;
            int spendForFood=companions*2;
            sumCoins-=spendForFood;

            if (count%5==0){
                int moneyFromBoss=companions*20;
                if (count%3==0){
                    int spendAditional=companions*5;
                    moneyFromBoss-=spendAditional;
                }
                sumCoins+=moneyFromBoss;
                continue;
            }else if (count%3==0){
                int spendForWater=companions*3;
                sumCoins-=spendForWater;
            }
        }




        int finRes=sumCoins/companions;

        System.out.printf("%d companions received %d coins each.",companions,Math.abs(finRes));
    }
}
