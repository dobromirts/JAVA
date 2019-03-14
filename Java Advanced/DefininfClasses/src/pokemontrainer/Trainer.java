package pokemontrainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private ArrayList<Pokemon>pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public boolean containsElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void decreaseHealth() {
        for (Pokemon pokemon : pokemons) {
            pokemon.setHealth(pokemon.getHealth()-10);
        }
    }

    public void removeDeadPokemons() {
        this.pokemons=pokemons.stream().filter(pokemon -> pokemon.getHealth()>0).collect(Collectors.toCollection(ArrayList::new));
    }
    @Override
    public String toString() {
        return String.format("%s %d %d%n",this.name,getBadges(),this.pokemons.size());
    }














    public String getName() {
        return name;
    }
    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


}
