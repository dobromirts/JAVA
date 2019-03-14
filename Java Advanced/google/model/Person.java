package model;

import sub.*;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    Company company;
    Car car;
    List<Parent> parents;
    List<Children> children;
    List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(String name, Company company) {
        this(name);
        this.company = company;
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Person(String name, Parent parent) {
        this(name);
        this.parents.add(parent);
    }

    public Person(String name, Children children) {
        this(name);
        this.children.add(children);
    }

    public Person(String name, Pokemon pokemon) {
        this(name);
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getName()).append("\n");

        output.append("Company:").append("\n");
        if (this.getCompany() != null) {
            output.append(this.getCompany().toString()).append("\n");
        }

        output.append("Car:").append("\n");
        if (this.getCar() != null) {
            output.append(this.getCar().toString()).append("\n");
        }

        output.append("Pokemon:").append("\n");
        StringBuilder pokemonsBuilder = new StringBuilder();
        if (this.getPokemons().size() != 0) {
            for (Pokemon pokemon : this.getPokemons()) {
                pokemonsBuilder.append(pokemon.toString()).append("\n");
            }
            output.append(pokemonsBuilder);
        }

        output.append("Parents:").append("\n");
        if (this.getParents().size() != 0) {
            StringBuilder parentBuilder = new StringBuilder();
            for (Parent parent : this.getParents()) {
                parentBuilder.append(parent.toString()).append("\n");
            }
            output.append(parentBuilder);
        }

        output.append("Children:").append("\n");
        if (this.getChildren().size() != 0) {
            StringBuilder childBuilder = new StringBuilder();
            for (Children child : this.getChildren()) {
                childBuilder.append(child.toString()).append("\n");
            }
            output.append(childBuilder);
        }


        return output.toString();
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

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
