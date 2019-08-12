package app.ccb.domain.dtos.json;

import com.google.gson.annotations.Expose;

public class BrancheImportDto {
    @Expose
    private String name;

    public BrancheImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
