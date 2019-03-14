package companyroster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private ArrayList<Employee>employees;

    public Department(String name){
        this.name=name;
        this.employees=new ArrayList<>();
    }

    public ArrayList<Employee>getEmployees(){
        return this.employees;
    }

    public Double getAverageSalary(){
        return this.employees.stream().mapToDouble(e->e.getSalary()).average().getAsDouble();
    }

}
