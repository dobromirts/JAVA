package softuni.cardealerxml.domain.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CarsWithPartsDto {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private List<PartsOfCarDto> partsOfCarDtos;

    public CarsWithPartsDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<PartsOfCarDto> getPartsOfCarDtos() {
        return partsOfCarDtos;
    }

    public void setPartsOfCarDtos(List<PartsOfCarDto> partsOfCarDtos) {
        this.partsOfCarDtos = partsOfCarDtos;
    }
}
