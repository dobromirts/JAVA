package callofduty.domain.agents;

import callofduty.domain.AgentImpl;
import callofduty.interfaces.BountyAgent;

public class MaterAgent extends AgentImpl implements BountyAgent {
    private static final double INIT_BOUNTY=0;



    private double bounty;


    public MaterAgent(String id, String name) {
        super(id, name);
        this.bounty=INIT_BOUNTY;
    }

    @Override
    public Double getBounty() {
        return null;
    }
}
