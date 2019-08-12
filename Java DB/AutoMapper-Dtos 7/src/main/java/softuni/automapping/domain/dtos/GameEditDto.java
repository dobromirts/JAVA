package softuni.automapping.domain.dtos;

import java.math.BigDecimal;

public class GameEditDto {
    private int id;
    private BigDecimal price;
    private Double size;

    @Override
    public String toString() {
        return "GameEditDto{}";
    }

    public GameEditDto(int id, BigDecimal price, Double size) {
        this.id = id;
        this.price = price;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
