package callofduty.domain.missions;

public class SurveillanceMission extends MissionImpl {
    public SurveillanceMission(String id, double rating, double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected void setRating(double rating) {
        super.setRating(rating-(rating*0.75));
    }

    @Override
    protected void setBounty(double bounty) {
        super.setBounty(bounty+(bounty*0.5));
    }
}
