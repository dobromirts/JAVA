//package app.hospitaldatabase;
//
//import app.BaseEntity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "diagnoses")
//public class Diagnose extends BaseEntity {
//    private String name;
//    private String comments;
//    private Gp gp;
//
//    public Diagnose() {
//    }
//@Column(name = "name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    @Column(name = "comments")
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
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
