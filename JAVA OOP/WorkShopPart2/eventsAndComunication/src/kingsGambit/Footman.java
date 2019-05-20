package kingsGambit;

public class Footman extends Unit implements Defender {
    public Footman(String name) {
        super(name);
    }

    @Override
    public String respondToAttack() {
          return String.format("Footman %s is panicking!",this.getName());
    }
}
