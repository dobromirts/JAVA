import exeptions.DuplicateModelExeption;

public class CommandHandler {

    private final ApplicationController appController;

    CommandHandler() {
        this.appController = new ApplicationController();
    }

       //SUSHTOTO E KATO FACTORY PATTERN SAMO CHE TAM RABOTQ S COMMAND RESULTA VRUSHA SUSHTO COMMAND
    //NA PRINCIMA NA SWICH CASE PAK S PURVA CHAST I DRUGITE DANNI S MASIVA I PRASHAM DA SE ORAVQT S COMMNAD PATTERTNA PO COMANDI
    public void handle(String[] split) throws DuplicateModelExeption {
        String result = "";
        switch (split[0]) {
            case "CreateBoatEngine":
                result = createBoatEngine(split);
                break;
            case "CreateRowBoat":
                createRowBoat(split);
                break;
            case "CreateSailBoat":
                break;
            case "CreateYachtBoat":
                break;
            case "CreatePowerBoat":
                break;
        }
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }

    private void createRowBoat(String[] split) throws DuplicateModelExeption {
        String model=split[1];
        double weight=Double.parseDouble(split[2]);
        int oars=Integer.parseInt(split[3]);
        this.appController.createRowBoat(model,weight,oars);
    }

    private String createBoatEngine(String[] args) throws DuplicateModelExeption {
        String model = args[1];
        int horsepower = Integer.parseInt(args[2]);
        int displacement = Integer.parseInt(args[3]);
        String type = args[4];
        this.appController.createEngine(model, horsepower, displacement, type);
        return String.format("Engine model %s with %s HP and %s cm3 created successfully.", model, horsepower, displacement);
    }
}
