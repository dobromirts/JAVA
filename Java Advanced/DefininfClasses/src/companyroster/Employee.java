package companyroster;

public class Employee {
    private static String EMAIL_DEF_VALUE="n/a";
    private static int AGE_DEF_VALUE=-1;


    private String name;
    private double salary;
    private String email;
    private  int age;



    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email=Employee.EMAIL_DEF_VALUE;
        this.age=Employee.AGE_DEF_VALUE;
    }


    public Employee(String name, double salary,String email){
        this(name,salary);
        this.email=email;
    }
    public Employee(String name, double salary,int age){
        this(name,salary);
        this.age =age;
    }

    public Employee(String name, double salary,String email,int age){
        this(name,salary,email);
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Employee.EMAIL_DEF_VALUE = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Employee.AGE_DEF_VALUE = age;
    }

    public String getInfo(){
      return   String.format("%s %.2f %s %d",this.name,this.salary,this.email,this.age);
    }
}
