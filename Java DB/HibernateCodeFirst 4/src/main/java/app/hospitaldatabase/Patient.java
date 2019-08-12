//package app.hospitaldatabase;
//
//import app.BaseEntity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "patients")
//public class Patient extends BaseEntity {
//    private String firstName;
//    private String lastName;
//    private String address;
//    private String email;
//    private Date dateOfBirth;
//    private String picture;
//    private Boolean medicalInsurance;
//    private Gp gp;
//
//
//
//    public Patient() {
//    }
//    @Column(name = "first_name")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    @Column(name = "last_name")
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    @Column(name = "address")
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//    @Column(name = "email")
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    @Column(name = "date_of_birth")
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//    @Column(name = "picture")
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//    @Column(name = "medical_insurance")
//    public Boolean getMedicalInsurance() {
//        return medicalInsurance;
//    }
//
//    public void setMedicalInsurance(Boolean medicalInsurance) {
//        this.medicalInsurance = medicalInsurance;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "gp_id",referencedColumnName = "id")
//    public Gp getGp() {
//        return gp;
//    }
//    public void setGp(Gp gp) {
//        this.gp = gp;
//    }
//}
