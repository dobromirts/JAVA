package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] robotsInfo = reader.readLine().split(";");
        String[] robots = new String[robotsInfo.length];
        int[] workingTime = new int[robotsInfo.length];
        int[] processTime = new int[robotsInfo.length];

        for (int i = 0; i < robotsInfo.length; i++) {
            robots[i] = robotsInfo[i].split("-")[0];
            workingTime[i] = Integer.parseInt(robotsInfo[i].split("-")[1]);

        }
        String[] timeData=reader.readLine().split(":");
        int hours=Integer.parseInt(timeData[0]);
        int minutes=Integer.parseInt(timeData[1]);
        int seconds=Integer.parseInt(timeData[2]);

        int startTime=hours*3600 + minutes*60 + seconds;
        int time=0;

        ArrayDeque<String>products=new ArrayDeque<>();
        String product=reader.readLine();

        while (!product.equals("End")){
            products.offer(product);
            product=reader.readLine();
        }

        while (!products.isEmpty()){
            time++;
            String currentProduct=products.poll();
            boolean isAssigned=false;

            for (int i = 0; i <robots.length ; i++) {
                if (processTime[i]==0&& !isAssigned){
                    processTime[i]=workingTime[i];
                    printTask(robots[i],startTime+time,currentProduct);
                    isAssigned=true;
                }
                if (processTime[i]>0){
                    processTime[i]--;
                }
            }
            if (!isAssigned){
                products.offer(currentProduct);
            }
        }
    }

    private static void printTask(String robot,int time,String product) {
        int hours=(time/3600)%24;
        int minutes=time%3600/60;
        int seconds=time%60;

        DecimalFormat df=new DecimalFormat("00");

        System.out.println(String.format("%s - %s [%s:%s:%s]",robot,product,df.format(hours),df.format(minutes),df.format(seconds)));
    }
}
