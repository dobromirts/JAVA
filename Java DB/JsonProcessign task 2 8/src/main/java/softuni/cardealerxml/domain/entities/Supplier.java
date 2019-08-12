package softuni.cardealerxml.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntiry{
    private String name;
    private Boolean isImporter;
    private Set<Part> parts;

    public Supplier() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_imported")
    public Boolean getImported() {
        return isImporter;
    }

    public void setImported(Boolean imported) {
        isImporter = imported;
    }

    @OneToMany(targetEntity = Part.class,mappedBy = "supplier")
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
