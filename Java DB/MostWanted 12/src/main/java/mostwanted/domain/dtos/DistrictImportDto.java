package mostwanted.domain.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictImportDto {
    @Expose
    private String name;
    @Expose
    @SerializedName("townName")
    private String town;

    public DistrictImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return town;
    }

    public void setTownName(String townName) {
        this.town = townName;
    }
}
