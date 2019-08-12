package softuni.jsonexercise.domain.dtos.QueriesDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SupplierLocalDto implements Serializable {
    @Expose
    private int Id;
    @Expose
    private String Name;
    @Expose
    private int PartsCount;

    public SupplierLocalDto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPartsCount() {
        return PartsCount;
    }

    public void setPartsCount(int partsCount) {
        PartsCount = partsCount;
    }
}
