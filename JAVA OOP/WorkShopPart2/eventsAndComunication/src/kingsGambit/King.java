package kingsGambit;

import java.util.Map;

public class King extends Unit implements Target{

    private Map<String,Defender>gards;
    public King(String name,Map<String,Defender>gards) {
        super(name);
        this.gards=gards;
    }

    @Override
    public void onAttacked() {
        System.out.println(String.format("King %s is under attack!",this.getName()));

        fireOnAttackEvent();
    }

    private void fireOnAttackEvent() {
        for (Map.Entry<String,Defender> s : gards.entrySet()) {
            System.out.println(s.getValue().respondToAttack());
        }
    }


}
