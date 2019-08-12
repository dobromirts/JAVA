//package app.hospitaldatabase;
//
//import app.BaseEntity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "visitations")
//public class Visitation extends BaseEntity {
//    private Date date;
//    private String comment;
//    private Gp gp;
//
//    @Column(name = "date")
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    @Column(name = "comment")
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "gp_id", referencedColumnName = "id")
//    public Gp getGp() {
//        return gp;
//    }
//
//    public void setGp(Gp gp) {
//        this.gp = gp;
//    }
//
//    public Visitation() {
//    }
//
//
//}
