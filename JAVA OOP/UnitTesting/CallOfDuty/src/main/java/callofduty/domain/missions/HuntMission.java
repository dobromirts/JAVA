package callofduty.domain.missions;

public class HuntMission extends MissionImpl {
    public HuntMission(String id, double rating, double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected void setRating(double rating) {
        super.setRating(rating+(rating*0.5));
    }

    @Override
    protected void setBounty(double bounty) {
        super.setBounty(bounty*2);
    }
}
