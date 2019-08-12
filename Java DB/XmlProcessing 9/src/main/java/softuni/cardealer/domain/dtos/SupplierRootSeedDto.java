package softuni.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootSeedDto {
    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> supplierSeedDtos;

    public SupplierRootSeedDto() {
    }

    public List<SupplierSeedDto> getSupplierSeedDtos() {
        return supplierSeedDtos;
    }

    public void setSupplierSeedDtos(List<SupplierSeedDto> supplierSeedDtos) {
        this.supplierSeedDtos = supplierSeedDtos;
    }
}
