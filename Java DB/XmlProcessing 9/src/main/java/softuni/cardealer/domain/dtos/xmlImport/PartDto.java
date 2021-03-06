package softuni.cardealer.domain.dtos.xmlImport;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartDto {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;
    @XmlAttribute
    private Integer quantity;
    @XmlTransient
    private SupplierDto supplierSeedDto;

    public PartDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SupplierDto getSupplierSeedDto() {
        return supplierSeedDto;
    }

    public void setSupplierSeedDto(SupplierDto supplierSeedDto) {
        this.supplierSeedDto = supplierSeedDto;
    }
}
