package softuni.jsonexercise.domain.dtos.SeedDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SupplierSeedDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
