package militaryElite.common;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName=codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (state.equals("inProgress ")){
            this.state = state;
        }else if (state.equals("Finished")){
            this.state = state;
        }
    }

    //TODO MAKE METHOD COMPLETE MISSION


    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s%n",this.codeName,this.state);
    }
}
