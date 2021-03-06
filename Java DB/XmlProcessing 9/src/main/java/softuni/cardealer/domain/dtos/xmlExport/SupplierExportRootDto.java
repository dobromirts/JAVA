package softuni.cardealer.domain.dtos.xmlExport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierExportRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierExportDto>supplierExportDtos;

    public SupplierExportRootDto() {
    }

    public List<SupplierExportDto> getSupplierExportDtos() {
        return supplierExportDtos;
    }

    public void setSupplierExportDtos(List<SupplierExportDto> supplierExportDtos) {
        this.supplierExportDtos = supplierExportDtos;
    }
}
