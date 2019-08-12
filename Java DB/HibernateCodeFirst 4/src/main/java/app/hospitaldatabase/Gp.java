//package app.hospitaldatabase;
//
//import app.BaseEntity;
//
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.Set;
//
//@Entity
//@Table(name = "gp")
//public class Gp extends BaseEntity {
//    private Set<Patient> patients;
//    private Set<Diagnose> diagnoses;
//    private Set<Medicament> medicaments;
//    private Set<Visitation> visitations;
//
//    public Gp() {
//    }
//
//    @OneToMany(targetEntity = Patient.class, mappedBy = "gp")
//    public Set<Patient> getPatients() {
//        return patients;
//    }
//
//    public void setPatients(Set<Patient> patients) {
//        this.patients = patients;
//    }
//
//    @OneToMany(targetEntity = Diagnose.class, mappedBy = "gp")
//    public Set<Diagnose> getDiagnoses() {
//        return diagnoses;
//    }
//
//    public void setDiagnoses(Set<Diagnose> diagnoses) {
//        this.diagnoses = diagnoses;
//    }
//
//    @OneToMany(targetEntity = Medicament.class, mappedBy = "gp")
//    public Set<Medicament> getMedicaments() {
//        return medicaments;
//    }
//
//    public void setMedicaments(Set<Medicament> medicaments) {
//        this.medicaments = medicaments;
//    }
//
//    @OneToMany(targetEntity = Visitation.class, mappedBy = "gp")
//    public Set<Visitation> getVisitations() {
//        return visitations;
//    }
//
//    public void setVisitations(Set<Visitation> visitations) {
//        this.visitations = visitations;
//    }
//}
