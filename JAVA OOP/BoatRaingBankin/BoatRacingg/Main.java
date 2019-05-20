import exceptions.*;


public class Main {

    public static void main(String[] args) throws DuplicateModelException, ArgumentException, InsufficientContestantsException, NoSetRaceException, RaceAlreadyExistsException {
        Executor executor = new Executor();
        executor.execute();

        //        Race race =
//                new Race(
//                    1.0,
//                    1.0,
//                    1.0,
//                    true);
//
//        Engine engine = new JetEngine("Engine Model", 123, 1200);
//        Boat racer1 = new Yacht("Yacht12", 12, engine, 123);
//        Boat racer2 = new PowerBoat("Yacht12", 12, engine, engine);
//
//        System.out.println(racer1.equals(racer2));
//
//        race.addParticipant(racer1);
//        race.addParticipant(racer2);
    }
}
