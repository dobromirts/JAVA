package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {

    private List<Hero>heroes;
    private Hero hero;

    public HeroRepository() {
        this.heroes = new ArrayList<>();
    }

    public void add(Hero hero){
        this.heroes.add(hero);
    }
    public void remove(String name){
        int index=0;
        for (Hero hero1 : heroes) {
            if (hero1.getName().equals(name)){
                heroes.remove(hero1);
                break;
            }
        }
    }
    public Hero getHeroWithHighestStrength(){
        Hero hero=this.heroes.stream().sorted((e1,e2)->{
            int first=e1.getItem().getStrength();
            int second=e2.getItem().getStrength();
            return Integer.compare(second,first);
        }).findFirst().get();
        return hero;
    }

    public Hero getHeroWithHighestAgility(){
        Hero hero=this.heroes.stream().sorted((e1,e2)->{
            int first=e1.getItem().getAgility();
            int second=e2.getItem().getAgility();
            return Integer.compare(second,first);
        }).findFirst().get();
        return hero;
    }
    public Hero getHeroWithHighestIntelligence(){
        Hero hero=this.heroes.stream().sorted((e1,e2)->{
            int first=e1.getItem().getIntelligence();
            int second=e2.getItem().getIntelligence();
            return Integer.compare(second,first);
        }).findFirst().get();
        return hero;
    }

    public int getCount(){
        return heroes.size();
    }


//    public String toString() {
//        return heroes;
//    }

}
