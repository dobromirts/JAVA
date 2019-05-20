package militaryElite.models;

public class SpecialisedSoldier extends PrivateImpl {
    private String corps;
    public SpecialisedSoldier(int id, String firstName, String lastName, double salary,String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    protected void setCorps(String corps) {
        if (corps.equals("Airforces")){
            this.corps=corps;
        }else if (corps.equals("Marines")){
            this.corps = corps;
        }
    }
}
