package softuni.cardealer.domain.dtos.xmlImport;



import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDto {

    @XmlElement
    private String make;

    @XmlElement
    private String model;

    @XmlElement(name = "travelled-distance")
    private Long travelledDistance;

    @XmlTransient
    private List<PartDto> partDtos;

    public CarDto() {
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

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartDto> getPartDtos() {
        return partDtos;
    }

    public void setPartDtos(List<PartDto> partDtos) {
        this.partDtos = partDtos;
    }
}