public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName,double weekSalary,double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }


    @Override
    public void setLastName(String lastName) {
        if (lastName.length()<4){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary<=10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary=weekSalary;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay<1 || workHoursPerDay>12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay=workHoursPerDay;
    }


//    private double salaryPerHour(double weekSalary,double workHoursPerDay){
//        return this.weekSalary/(7*this.workHoursPerDay);
//    }
//
//    public double getSalaryPerHour(){
//        return salaryPerHour(weekSalary,workHoursPerDay);
//    }



//    @Override
//    public String toString() {
//        //o	First Name: {worker's first name}
//        //o	Last Name: {worker's second name}
//        //o	Week Salary: {worker's salary}
//        //o	Hours per day: {worker's working hours}
//        //o	Salary per hour: {worker's salary per hour}
//
//        return String.format("First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f%n",
//                super.getFirstName(),super.getLastName(),this.weekSalary,this.workHoursPerDay,this.getSalaryPerHour());
//    }
}
