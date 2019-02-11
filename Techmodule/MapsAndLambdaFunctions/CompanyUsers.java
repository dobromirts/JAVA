import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String, List<String>>workersInEachCompany=new LinkedHashMap<>();

        while (!input.equals("End")){
            String []tokens=input.split(" -> ");
            String companyNmae=tokens[0];
            String id=tokens[1];

            workersInEachCompany.putIfAbsent(companyNmae,new ArrayList<>());

            if (!workersInEachCompany.get(companyNmae).contains(id)){
                workersInEachCompany.get(companyNmae).add(id);
            }

            input=scanner.nextLine();
        }
        workersInEachCompany.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry->{
                    System.out.printf("%s%n",entry.getKey());
                    entry.getValue().stream().forEach(w->{
                        System.out.printf("-- %s%n",w);
                    });
                });
    }
}
