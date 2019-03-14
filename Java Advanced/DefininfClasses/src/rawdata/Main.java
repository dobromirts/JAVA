package rawdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        LinkedList<Car> cars=new LinkedList<>();

        while (n-->0){
            String []tokens=scanner.nextLine().split(" ");
            String model=tokens[0];
            int engineSpeed=Integer.parseInt(tokens[1]);
            int enginePower=Integer.parseInt(tokens[2]);
            Engine engine=new Engine(engineSpeed,enginePower);
            int cargoWeight=Integer.parseInt(tokens[3]);
            String cargoType=tokens[4];
            Cargo cargo=new Cargo(cargoWeight,cargoType);
            double tire1Pressure=Double.parseDouble(tokens[5]);
            int tire1Age=Integer.parseInt(tokens[6]);
            Tire tire1=new Tire(tire1Pressure);
            double tire2Pressure=Double.parseDouble(tokens[7]);
            int tire2Age=Integer.parseInt(tokens[8]);
            Tire tire2=new Tire(tire2Pressure);
            double tire3Pressure=Double.parseDouble(tokens[9]);
            int tire3Age=Integer.parseInt(tokens[10]);
            Tire tire3=new Tire(tire3Pressure);
            double tire4Pressure=Double.parseDouble(tokens[11]);
            int tire4Age=Integer.parseInt(tokens[12]);
            Tire tire4=new Tire(tire4Pressure);

            Car car=new Car(model,engine,cargo);
            car.getTires().add(tire1);
            car.getTires().add(tire2);
            car.getTires().add(tire3);
            car.getTires().add(tire4);

            cars.add(car);


        }

        String command=scanner.nextLine();
        if (command.equals("fragile")){
            for (Car car : cars) {
                ArrayList<Tire>tire=car.getTires();
                double prs=0;
                for (Tire tire1 : tire) {
                    if (tire1.getPresure()>1){
                        continue;
                    }else {
                        prs+=1;
                    }
                }
                if (prs>0){
                    System.out.println(car.getModel());
                }
            }


        }else if (command.equals("flamable")){
            for (Car car : cars) {
                if (car.getEnginePower()>250 && car.getCargoType().equals("flamable") ){
                    System.out.println(car.getModel());
                }
            }
        }

    }
}
