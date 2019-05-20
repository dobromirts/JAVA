package militaryElite.application;

import militaryElite.interfaces.Soldier;
import militaryElite.models.LeutenantGeneralImpl;
import militaryElite.models.PrivateImpl;

import java.util.List;

public class Command {
    private final Army ARMY=new Army();

    public Army getArmy(){
        return this.ARMY;
    }


    public void execute(String command, List<String>tokens){
        int id=Integer.parseInt(tokens.get(0));
        String firstName=tokens.get(1);
        String lastName=tokens.get(2);


        Soldier soldier=null;
        if (command.equals("Private")){
            soldier=new PrivateImpl(id,firstName,lastName,Double.parseDouble(tokens.get(3)));
        }else if (command.equals("LeutenantGeneral")){
            soldier=new LeutenantGeneralImpl(id,firstName,lastName,Double.parseDouble(tokens.get(3)));

            int[] ids = tokens.stream().skip(4).mapToInt(Integer::parseInt)
                    .toArray();
            for (int currentId : ids) {
                for (int i = 0; i < this.getArmy().getSoldiers().size(); i++) {
                    if (this.getArmy().getSoldiers().get(i) instanceof PrivateImpl){
                        if (this.getArmy().getSoldiers().get(i).getId()==currentId){

                        }
                    }
                    
                }
            }
        }

        if (soldier!=null){
            this.getArmy().addSoldier(soldier);
        }


    }
}
