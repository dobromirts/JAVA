package softuni.cardealerxml.domain.dtos;

import com.google.gson.annotations.Expose;

public class LocalSupplyerDto {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private Integer partsCount;

    public LocalSupplyerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}
