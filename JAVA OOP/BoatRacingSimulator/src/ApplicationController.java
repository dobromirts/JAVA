
import boats.RowBoat;
import engines.Jet;
import engines.Sterndrive;
import exeptions.DuplicateModelExeption;
import interfaces.Boat;
import interfaces.BoatEngine;
import repositories.BoatRepository;
import repositories.EngineRepository;

public class ApplicationController {

    private static final String JET_ENGINE = "Jet";
    private EngineRepository engineRepository;
    private BoatRepository boatRepository;

    public ApplicationController() {
        this.engineRepository = new EngineRepository();
        this.boatRepository=new BoatRepository();
    }

    public void createEngine(String model, int horsepower, int displacement, String type) throws DuplicateModelExeption {
        BoatEngine result=null;
        if (type.equals(JET_ENGINE)){
            result=new Jet(model,horsepower,displacement);
        }else {
            result=new Sterndrive(model,horsepower,displacement);
        }

        boolean saveResult=this.engineRepository.save(result);
        if (!saveResult){
            throw new DuplicateModelExeption();
        }
    }
    public void createRowBoat(String model,double weight,int oars) throws DuplicateModelExeption {
        Boat boat=new RowBoat(model,weight,oars);

        boolean saveResult=this.boatRepository.save(boat);
        if (!saveResult){
            throw new DuplicateModelExeption();
        }
    }
}
