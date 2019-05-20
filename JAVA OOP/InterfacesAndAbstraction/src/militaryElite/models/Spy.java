package militaryElite.models;

public class Spy extends SoldierImpl{
    private String codeNumber;


    public Spy(int id, String firstName, String lastName,String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber=codeNumber;
    }

    //Name: <firstName> <lastName> Id: <id>
    //Code Number: <codeNumber>


    @Override
    public String toString() {
        return String.format("%s%nCode Number: %s%n",super.toString(),this.codeNumber);
    }
}
