package google;

import java.util.ArrayList;

public class Person {
    String name;
    Company company;
    Car car;
    ArrayList<Pokemon>pokemons;
    ArrayList<Parents>parents;
    ArrayList<Children>children;

    public Person(String name, Company company, Car car) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }
    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Parents> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parents> parents) {
        this.parents = parents;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }
}
