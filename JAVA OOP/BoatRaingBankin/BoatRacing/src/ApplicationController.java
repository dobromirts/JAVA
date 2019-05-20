import exceptions.*;
import model.BoatResult;
import model.boat.*;
import model.engine.Engine;
import model.engine.JetEngine;
import model.engine.SterndriveEngine;
import model.race.Race;
import repository.BoatRepository;
import repository.EngineRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationController {
    private static final String JET_ENGINE = "Jet";
    private EngineRepository engineRepository;
    private BoatRepository boatRepository;
    private Race currentRace;

    ApplicationController() {
        this.engineRepository = new EngineRepository();
        this.boatRepository = new BoatRepository();

        this.currentRace = null;
    }

    public void createEngine(String model,
                               int horsepower,
                               int displacement,
                               String type) throws DuplicateModelException {

        Engine result = null;
        if (type.equals(JET_ENGINE)) {
            result = new JetEngine(model, horsepower, displacement);
        } else {
            result = new SterndriveEngine(model, horsepower, displacement);
        }

        boolean saveResult = this.engineRepository.save(result);
        if (!saveResult) {
            throw new DuplicateModelException();
        }
    }

    public void createRowBoat(String model, double weight, int oars) {
        Boat boat = new RowBoat(model, weight, oars);

        this.boatRepository.save(boat);
    }

    public void createSailBoat(String model, double weight, int sailEfficiency) {
        Boat boat = new SailBoat(model, weight, sailEfficiency);

        this.boatRepository.save(boat);
    }

    public void createPowerBoat(String model, double weight, String firstEngineModel, String secondEngineModel) {
        Engine engineOne = this.engineRepository.getByModel(firstEngineModel);
        Engine engineTwo = this.engineRepository.getByModel(secondEngineModel);

        Boat boat = new PowerBoat(model, weight, engineOne, engineTwo);

        this.boatRepository.save(boat);
    }

    public void createYacht(String model, double weight, String firstEngineModel, double cargo) {
        Engine engineOne = this.engineRepository.getByModel(firstEngineModel);

        Boat boat = new Yacht(model, weight, engineOne, cargo);

        this.boatRepository.save(boat);
    }

    public void openRace(double distance, double windSpeed, double currentSpeed, boolean allowMotorboats) throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException();
        }

        this.currentRace = new Race(distance, windSpeed, currentSpeed, allowMotorboats);
    }

    public void signUpBoat(String model) throws NoSetRaceException, DuplicateModelException, ArgumentException {
        if (this.currentRace == null) {
            throw new NoSetRaceException();
        }

        Boat participant = this.boatRepository.getByModel(model);

        this.currentRace.addParticipant(participant);
    }

    public List<BoatResult> startRace() throws NoSetRaceException, InsufficientContestantsException {
        if (this.currentRace == null) {
            throw new NoSetRaceException();
        }

        if (!this.currentRace.enoughParticipants()) {
            throw new InsufficientContestantsException();
        }

        return this.currentRace.getParticipants()
                .stream()
                .sorted((f, s) ->
                    Double.compare(
                        s.getSpeed(this.currentRace.getConditions()),
                        f.getSpeed(this.currentRace.getConditions())))
                .limit(3)
                .map(b -> {
                    double speed = b.getSpeed(this.currentRace.getConditions());
                    double time = this.currentRace.getDistance() / speed;

                    return new BoatResult(b, time);
                })
                .collect(Collectors.toList());
    }
}
