import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         int n =Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>>studenGrades=new LinkedHashMap<>();


         while (n-->0){
             String name=scanner.nextLine();
             double grade=Double.parseDouble(scanner.nextLine());


             if (!studenGrades.containsKey(name)){
                 studenGrades.put(name,new ArrayList<>());
                 studenGrades.get(name).add(grade);
             }else {
                 studenGrades.get(name).add(grade);
             }
         }

         Map<String,Double>averageStudents=new LinkedHashMap<>();

        for (String s : studenGrades.keySet()) {
            double sum=0;
            for (int i = 0; i <studenGrades.get(s).size() ; i++) {
                sum+=studenGrades.get(s).get(i);
            }
            double average=sum/studenGrades.get(s).size();
            if (average>=4.50){
                averageStudents.put(s,average);
            }
        }
        averageStudents.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed())
                .forEach(entry->{
                    System.out.println(String.format("%s -> %.2f",entry.getKey(),entry.getValue()));
                });
    }
}
