import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class VehicleCatalog {
    private String type;
    private String model;
    private String color;
    private int horsePower;

    public VehicleCatalog(String type, String model, String color, int horsePower) {
        this.setType(type);
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }
    private void setType(String type){
        type=type.replace(type.charAt(0),Character.toUpperCase(type.charAt(0)));
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
    public String getModel(){
        return this.model;
    }
    public int getHorsepower(){
        return this.horsePower;
    }
//Type: {typeOfVehicle}
//Model: {modelOfVehicle}
//Color: {colorOfVehicle}
//Horsepower: {horsepowerOfVehicle}
    @Override
    public String toString() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",this.type,this.model,this.color,this.getHorsepower());
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<VehicleCatalog>cars=new ArrayList<>();
        List<VehicleCatalog>trucks=new ArrayList<>();

        String input=scanner.nextLine();
        while (!input.equals("End")){
            String[]tokens=input.split(" ");
            String type=tokens[0];
            String model=tokens[1];
            String color=tokens[2];
            int horsep=Integer.parseInt(tokens[3]);

            VehicleCatalog vehicleCatalog=new VehicleCatalog(type,model,color,horsep);

            if (vehicleCatalog.getType().equals("Truck")){
                trucks.add(vehicleCatalog);
            }else {
                cars.add(vehicleCatalog);
            }


            input=scanner.nextLine();
        }
        input=scanner.nextLine();
        while (!input.equals("Close the Catalogue")){
            String model=input;
            for (VehicleCatalog truck : trucks) {
                if (truck.getModel().equals(model)){
                    System.out.println(truck.toString());
                }
            }
            for (VehicleCatalog car : cars) {
                if (car.getModel().equals(model)){
                    System.out.println(car.toString());
                }
            }


            input=scanner.nextLine();
        }
        double truckHpaverage=0;
        double carHpaverage=0;
        double carHpSum=0;
        double truckHpSum=0;

        if (!cars.isEmpty()){
            for (VehicleCatalog car : cars) {
                carHpSum+=car.getHorsepower();
            }
            carHpaverage=carHpSum/cars.size();
        }
        System.out.println(String.format("Cars have average horsepower of: %.2f.",carHpaverage));
        if (!trucks.isEmpty()){
            for (VehicleCatalog truck : trucks) {
                truckHpSum+=truck.getHorsepower();
            }
            truckHpaverage=truckHpSum/trucks.size();
        }
        System.out.println(String.format("Trucks have average horsepower of: %.2f.",truckHpaverage));


    }
}
