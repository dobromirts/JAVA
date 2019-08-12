package softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class CarWithPartsDto implements Serializable {
    @Expose
    private CarDto car;
    @Expose
    private List<PartDto> parts;

    public CarWithPartsDto() {
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public List<PartDto> getParts() {
        return parts;
    }

    public void setParts(List<PartDto> parts) {
        this.parts = parts;
    }
}
