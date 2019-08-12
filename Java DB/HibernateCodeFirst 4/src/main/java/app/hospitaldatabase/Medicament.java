//package app.hospitaldatabase;
//
//import app.BaseEntity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "medicaments")
//public class Medicament extends BaseEntity {
//    private String name;
//    private Gp gp;
//
//    public Medicament() {
//    }
//
//    @Column(name = "name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "gp_id",referencedColumnName = "id")
//    public Gp getGp() {
//        return gp;
//    }
//
//    public void setGp(Gp gp) {
//        this.gp = gp;
//    }
//}
