package kingsGambit;

public class RoyalGuard extends Unit implements Defender {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public String respondToAttack() {
        return String.format("Royal Guard %s is defending!",this.getName());
    }
}
