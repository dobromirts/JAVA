package callofduty.domain.missions;

public class EscortMission extends MissionImpl {
    public EscortMission(String id, double rating, double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected void setRating(double rating) {
        super.setRating(rating-(rating*0.25));
    }

    @Override
    protected void setBounty(double bounty) {
        super.setBounty(bounty+(bounty*0.25));
    }
}
