package google;

public class Parents {
    //<Name> parents <parentName> <parentBirthday>”
    String parentName;
    String parrentBirthday;

    public Parents(String parentName, String parrentBirthday) {
        this.parentName = parentName;
        this.parrentBirthday = parrentBirthday;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParrentBirthday() {
        return parrentBirthday;
    }

    public void setParrentBirthday(String parrentBirthday) {
        this.parrentBirthday = parrentBirthday;
    }
}
