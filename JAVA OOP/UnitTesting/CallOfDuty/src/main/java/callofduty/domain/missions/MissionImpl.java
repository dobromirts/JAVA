package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public class MissionImpl implements Mission {
    private String id;
    private double rating;
    private double bounty;


    public MissionImpl(String id, double rating, double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
    }

    protected void setRating(double rating) {
        this.rating = rating;
    }

    protected void setBounty(double bounty) {
        this.bounty = bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }
}
