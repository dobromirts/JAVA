public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName,String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length()<5 || facultyNumber.length()>10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber=facultyNumber;
    }

//    public String getFacultyNumber() {
//        return facultyNumber;
//    }

//    @Override
//    public String toString() {
//        return String.format("First Name: %s%nLast Name: %s%nFaculty number: %s%n"
//                ,super.getFirstName(),super.getLastName(),this.getFacultyNumber());
//    }
}
