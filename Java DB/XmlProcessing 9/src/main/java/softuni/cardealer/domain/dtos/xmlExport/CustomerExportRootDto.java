package softuni.cardealer.domain.dtos.xmlExport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportRootDto {

    @XmlElement(name = "customer")
    private List<CustomerExportDto> customerExportDtos;

    public CustomerExportRootDto() {
    }

    public List<CustomerExportDto> getCustomerExportDtoList() {
        return customerExportDtos;
    }

    public void setCustomerExportDtoList(List<CustomerExportDto> customerExportDtoList) {
        this.customerExportDtos = customerExportDtoList;
    }
}
