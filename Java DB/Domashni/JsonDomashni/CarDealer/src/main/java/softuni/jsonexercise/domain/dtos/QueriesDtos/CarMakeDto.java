package softuni.jsonexercise.domain.dtos.QueriesDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CarMakeDto implements Serializable {
    @Expose
    private int Id;
    @Expose
    private String Make;
    @Expose
    private String Model;
    @Expose
    private long TravelledDistance;

    public CarMakeDto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public long getTravelledDistance() {
        return TravelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        TravelledDistance = travelledDistance;
    }
}
