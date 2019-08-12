package softuni.cardealer.domain.dtos.xmlExport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportRootDto2 {

    @XmlElement(name = "car")
    private List<CarExportDto2>carExportDto2s;

    public CarExportRootDto2() {
    }

    public List<CarExportDto2> getCarExportDto2s() {
        return carExportDto2s;
    }

    public void setCarExportDto2s(List<CarExportDto2> carExportDto2s) {
        this.carExportDto2s = carExportDto2s;
    }
}
