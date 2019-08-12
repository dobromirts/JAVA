package softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CarDto implements Serializable {
    @Expose
    private String Make;
    @Expose
    private String Model;
    @Expose
    private long TravelledDistance;

    public CarDto() {
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
