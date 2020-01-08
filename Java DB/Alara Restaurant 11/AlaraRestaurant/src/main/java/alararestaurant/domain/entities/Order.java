package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    private String customer;
    private String dateTime;
    private OrderType type;
    private Employee employee;
    private List<OrderItem>orderItems;

    public Order() {
    }

    @Column(name = "customer",nullable = false,length = 1000)
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Column(name = "date_time",nullable = false)
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    @Column(name = "type",nullable = false,columnDefinition = "varchar(32) default 'ForHere'")
    @Enumerated(EnumType.STRING)
    public OrderType getOrderType() {
        return type;
    }

    public void setOrderType(OrderType orderType) {
        this.type = orderType;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id",referencedColumnName = "id",nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy = "order")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}