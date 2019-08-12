package alararestaurant.domain.dtos.xmlDtos;

import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.OrderType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDto {
    @XmlElement(name = "customer")
    private String customer;

    @XmlElement(name = "date-time")
    private String dateTime;

    @XmlElement(name = "type")
    private OrderType type;

    @XmlElement(name = "employee")
    private String employee;

    @XmlElement(name = "items")
    private List<ItemRootDto>itemRootDtos;

    public OrderDto() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public List<ItemRootDto> getItemRootDtos() {
        return itemRootDtos;
    }

    public void setItemRootDtos(List<ItemRootDto> itemRootDtos) {
        this.itemRootDtos = itemRootDtos;
    }
}
