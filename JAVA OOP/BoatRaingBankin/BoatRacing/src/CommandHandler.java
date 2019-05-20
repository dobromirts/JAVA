import command.Command;
import exceptions.*;
import model.BoatResult;
import model.boat.Boat;
import model.boat.SailBoat;
import model.boat.Yacht;
import model.engine.Engine;
import model.race.Race;

import java.text.DecimalFormat;
import java.util.List;

public class CommandHandler {
    private final String TRUE_STRING = "true";

    private final ApplicationController appController;

    CommandHandler() {
        this.appController = new ApplicationController();
    }

    public void handle(String[] split) throws DuplicateModelException, RaceAlreadyExistsException, NoSetRaceException, ArgumentException, InsufficientContestantsException {
        String result = "";
        switch (split[0]) {
            case "CreateBoatEngine":
                result = createBoatEngine(split);
                break;
            case "CreateRowBoat":
                createRowBoat(split);
                break;
            case "CreateSailBoat":
                createSailBoat(split);
                break;
            case "CreatePowerBoat":
                createPowerBoat(split);
                break;
            case "CreateYacht":
                createYacht(split);
                break;
            case "OpenRace":
                result = openRace(split);
                break;
            case "SignUpBoat":
                signUpBoat(split);
                break;
            case "StartRace":
                startRace();
                break;
        }

        if (!result.isEmpty()) System.out.println(result);
    }

    private void startRace() throws NoSetRaceException, InsufficientContestantsException {
        List<BoatResult> top3 = this.appController.startRace();

        printScore("First place", top3.get(0));
        printScore("Second place", top3.get(1));
        printScore("Third place", top3.get(2));
    }

    private void printScore(String title, BoatResult raceResult) {
        DecimalFormat formatter = new DecimalFormat("####.##");
        double raceTime = raceResult.getRaceTime();

        System.out.printf("%s: %s Model: %s Time: %s%n",
            title,
            raceResult.getBoat().getClass().getSimpleName(),
            raceResult.getBoat().getModel(),
            raceTime <= 0 ? "Did not finish!" : formatter.format(raceTime) + " sec");
    }

    private void signUpBoat(String[] split) throws NoSetRaceException, DuplicateModelException, ArgumentException {
        String model = split[1];

        this.appController.signUpBoat(model);
    }

    private String openRace(String[] split) throws RaceAlreadyExistsException {
        double distance = Double.parseDouble(split[1]);
        double windSpeed = Double.parseDouble(split[2]);
        double currentSpeed = Double.parseDouble(split[3]);

        boolean allowMotorboats = split[4].equals(TRUE_STRING);
        this.appController.openRace(
            distance, windSpeed, currentSpeed, allowMotorboats
        );

        return String.format("A new race with distance %.0f meters, " +
                "wind speed %.0f and ocean current speed %.0f has been set.",
                distance, windSpeed, currentSpeed);
    }

    private void createYacht(String[] split) {
        String model = split[1];
        double weight = Double.parseDouble(split[2]);
        String firstEngineModel = split[3];
        double cargo = Double.parseDouble(split[4]);

        this.appController.createYacht(
                model,
                weight,
                firstEngineModel,
                cargo);
    }

    private void createPowerBoat(String[] split) {
        String model = split[1];
        double weight = Double.parseDouble(split[2]);
        String firstEngineModel = split[3];
        String secondEngineModel = split[4];

        this.appController.createPowerBoat(
                model,
                weight,
                firstEngineModel,
                secondEngineModel);

    }

    private void createSailBoat(String[] split) {
        String model = split[1];
        double weight = Double.parseDouble(split[2]);
        int sailEfficiency = Integer.parseInt(split[3]);

        this.appController.createSailBoat(
            model,
            weight,
            sailEfficiency
        );
    }

    private void createRowBoat(String[] split) {
        String model = split[1];
        double weight = Double.parseDouble(split[2]);
        int oars = Integer.parseInt(split[3]);

        this.appController.createRowBoat(
            model,
            weight,
            oars
        );
    }

    private String createBoatEngine(String[] args) throws DuplicateModelException {
        String model = args[1];
        int horsepower = Integer.parseInt(args[2]);
        int displacement = Integer.parseInt(args[3]);
        String type = args[4];

        this.appController.createEngine(
                model,
                horsepower,
                displacement,
                type
        );

        return String.format("Engine model %s with %d HP and displacement " +
                        "%d cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }


}
