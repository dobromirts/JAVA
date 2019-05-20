import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]studentInformation=scanner.nextLine().split(" ");
        String[]workerInformarion=scanner.nextLine().split(" ");

        try {
            Student student=new Student(studentInformation[0],studentInformation[1],studentInformation[2]);
            Worker worker=new Worker(
                    workerInformarion[0],
                    workerInformarion[1],
                    Double.parseDouble(workerInformarion[2]),
                    Double.parseDouble(workerInformarion[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());


        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
