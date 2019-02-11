import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Students {
    String firstName;
    String lastName;
    double grade;

    public Students(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
    public double getGrade(){
        return this.grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f",this.firstName,this.lastName,this.getGrade());
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        List<Students>result=new ArrayList<>();

        while (n-->0){
            String[]tokens=scanner.nextLine().split(" ");
            String firstname=tokens[0];
            String lastname=tokens[1];
            double grade=Double.parseDouble(tokens[2]);
            Students students=new Students(firstname,lastname,grade);

            result.add(students);
        }

        result.stream().sorted(Comparator.comparing(Students::getGrade).reversed()).forEach(p-> System.out.println(p));

    }
}
