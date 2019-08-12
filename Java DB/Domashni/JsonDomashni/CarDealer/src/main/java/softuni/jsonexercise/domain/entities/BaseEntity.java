package softuni.jsonexercise.domain.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private int id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable=false, updatable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
