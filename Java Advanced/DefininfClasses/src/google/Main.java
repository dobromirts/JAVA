package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        HashMap<String,Person>peopleByName=new HashMap<>();


        while (!input.equals("End")){
            String[]tokens=input.split(" ");

            String personName=tokens[0];

            if (!peopleByName.containsKey(personName)){
                peopleByName.put(personName,new Person());
            }
            Pokemon pokemon=null;
            Parents parents=null;
            Children children=null;
            switch (tokens[1]){

                case "company":
                    Company company=new Company(tokens[2],tokens[3],Double.parseDouble(tokens[4]));
                    peopleByName.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    pokemon=new Pokemon(tokens[2],tokens[3]);
                    peopleByName.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    parents=new Parents(tokens[2],tokens[3]);
                    peopleByName.get(personName).getParents().add(parents);
                    break;
                case "children":
                    children=new Children(tokens[2],tokens[3]);
                    peopleByName.get(personName).getChildren().add(children);
                    break;
                case "car":
                    Car car=new Car(tokens[2],Integer.parseInt(tokens[3]));
                    peopleByName.get(personName).setCar(car);
                    break;
            }




            input=scanner.nextLine();
        }

        String informationForPerson=scanner.nextLine();
//        	{personName}
//	Company:
//	{companyName} {companyDepartment} {salary}
//	...
//	Children:
//	{childName} {childBirthday}
//	{childName} {childBirthday}

        Person personInfo=peopleByName.get(informationForPerson);
        System.out.println(informationForPerson);
        System.out.println("Company:");
        if (personInfo.getCompany()!=null){
            System.out.printf("%s %s %.2f%n",personInfo.getCompany().getCompanyName(),personInfo.getCompany().getCompanyName(),
                    personInfo.getCompany().getSalary());
        }
        System.out.println("Car:");
        System.out.printf("%s %d%n",personInfo.getCar().getCarModel(),personInfo.getCar().getCarSpeed());
        System.out.println("Pokemon:");
        if (!personInfo.getPokemons().isEmpty()){
            ArrayList<Pokemon>pokemons=peopleByName.get(personInfo).getPokemons();
            for (Pokemon pokemon : pokemons) {
                System.out.printf("%s %s%n",pokemon.getPokemonName(),pokemon.getPokemonType());
            }
        }
        System.out.println("Children:");
        if (!personInfo.getChildren().isEmpty()){
            ArrayList<Children>children=peopleByName.get(personInfo).getChildren();
            for (Children child : children) {
                System.out.printf("%s %s%n",child.getChildName(),child.getChildBirthday());
            }
        }
        System.out.println("Parents::");
        if (!personInfo.getParents().isEmpty()){
            ArrayList<Parents>parents=peopleByName.get(personInfo).getParents();
            for (Parents parent : parents) {
                System.out.printf("%s %s%n",parent.getParentName(),parent.getParrentBirthday());
            }
        }



    }
}
