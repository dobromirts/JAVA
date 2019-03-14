import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Intership {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Pattern pattern=Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
        int problemsColunt=Integer.parseInt(scanner.nextLine());
        int candidatesCount=Integer.parseInt(scanner.nextLine());

        ArrayDeque<String>problems=new ArrayDeque<>();
        ArrayDeque<String>candidates=new ArrayDeque<>();

        for (int i = 0; i <problemsColunt ; i++) {
            problems.push(scanner.nextLine());
        }
        for (int i = 0; i <candidatesCount ; i++) {
            String currentCandidate=scanner.nextLine();
            Matcher matcher=pattern.matcher(currentCandidate);
            if (matcher.find()){
                candidates.offer(currentCandidate);
            }
        }
        String currentProblem="";

        while (candidates.size()>1 || problems.size()>0){

            currentProblem = problems.pop();

            String currentCandidate=candidates.poll();

            int problemSum=0;
            int candidateSum=0;

            for (int i = 0; i <currentProblem.length() ; i++) {
                problemSum+=currentProblem.charAt(i);
            }
            for (int i = 0; i <currentCandidate.length() ; i++) {
                candidateSum+=currentCandidate.charAt(i);
            }

            if (candidateSum>problemSum){
                candidates.addLast(currentCandidate);
                System.out.printf("%s solved %s.%n",currentCandidate,currentProblem);
            }else {
                problems.addLast(currentProblem);
                System.out.printf("%s failed %s.%n",currentCandidate,currentProblem);
            }

            if (candidates.size()==1){
                System.out.printf("%s gets the job!",candidates.peek());
                break;
            }
            if (problems.size()==0){
                for (String candidate : candidates) {
                    System.out.println(String.join(", ",candidate));
                }
                break;

            }


        }


    }
}
