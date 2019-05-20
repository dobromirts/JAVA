package militaryElite.models;

import militaryElite.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName);
        this.salary=salary;
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f",super.toString(),getSalary());
    }
}
