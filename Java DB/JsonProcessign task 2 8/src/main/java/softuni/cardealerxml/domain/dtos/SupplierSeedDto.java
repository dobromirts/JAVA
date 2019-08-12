package softuni.cardealerxml.domain.dtos;

import com.google.gson.annotations.Expose;

public class SupplierSeedDto {
    @Expose
    private String name;
    @Expose
    private Boolean isImporter;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImported() {
        return isImporter;
    }

    public void setImported(Boolean imported) {
        isImporter = imported;
    }
}
