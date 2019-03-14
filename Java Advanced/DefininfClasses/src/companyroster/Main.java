package companyroster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rotations=Integer.parseInt(scanner.nextLine());
        HashMap<String,Department> departmentHashMap=new HashMap<>();

        for (int i = 0; i <rotations ; i++) {
            String[]tokens=scanner.nextLine().split(" ");

            String departmentName=tokens[3];

            Employee employee=null;
            switch (tokens.length){
                case 4:
                    employee=new Employee(tokens[0],Double.parseDouble(tokens[1]));
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        employee =new Employee(tokens[0],Double.parseDouble(tokens[1]),tokens[4]);
                    }else {
                        employee =new Employee(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[4]));
                    }
                    break;
                    default:
                        employee=new Employee(tokens[0],Double.parseDouble(tokens[1]),tokens[4],Integer.parseInt(tokens[5]));
            }

            if (!departmentHashMap.containsKey(departmentName)){
                departmentHashMap.put(departmentName,new Department(departmentName));
            }
            departmentHashMap.get(departmentName).getEmployees().add(employee);
        }
        departmentHashMap.entrySet().stream().sorted((e1,e2)->e2.getValue().getAverageSalary().compareTo(e1.getValue().getAverageSalary()))
                .findFirst()
                .stream()
                .forEach(e->{
                    System.out.println("Highest Average Salary: "+e.getKey());
                    e.getValue().getEmployees().stream().sorted((e1,e2)->{
                       return Double.compare(e2.getSalary(),e1.getSalary());
                    }).forEach(entry-> System.out.println(entry.getInfo()));
                });
    }
}
