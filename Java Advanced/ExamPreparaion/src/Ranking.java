import java.util.*;
import java.util.stream.IntStream;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,String>contents=new HashMap<>();
        TreeMap<String,HashMap<String,Integer>> candidatesFullInformation=new TreeMap<>();

        String input=scanner.nextLine();
        while (!input.equals("end of contests")){
            String[]tokens=input.split(":");
            String content=tokens[0];
            String password=tokens[1];

            if (!contents.containsKey(content)){
                contents.put(content,password);
            }

            input=scanner.nextLine();
        }

        String submitions=scanner.nextLine();
        while (!submitions.equals("end of submissions")){
            //contest}=>{password}=>{username}=>{points}”
            String[]tokens=submitions.split("=>");
            String contest=tokens[0];
            String password=tokens[1];
            String username=tokens[2];
            int points=Integer.parseInt(tokens[3]);

            if (contents.containsKey(contest)){
                if (contents.get(contest).equals(password)){
                    if (candidatesFullInformation.containsKey(username)){
                        if (candidatesFullInformation.get(username).containsKey(contest)){
                            candidatesFullInformation.get(username).put(contest,points);
                        }else {
                            candidatesFullInformation.get(username).put(contest,points);
                        }
                    }else {
                        candidatesFullInformation.put(username,new HashMap<>());
                        candidatesFullInformation.get(username).put(contest,points);
                    }
                }
            }




            submitions=scanner.nextLine();
        }
//        String bestUser=candidatesFullInformation.entrySet().stream().sorted((x1,x2)->{
//            int value1= x1.getValue().values().stream().mapToInt(Integer::valueOf).sum();
//            int value2=x2.getValue().values().stream().mapToInt(Integer::valueOf).sum();
//            return Integer.compare(value2,value1);
//        }).findFirst().get().getKey();

        String bestUser = candidatesFullInformation.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> x.getValue().values().stream().mapToInt(Integer::valueOf).sum(),
                        Comparator.reverseOrder()))
                .findFirst()
                .get()
                .getKey();

        System.out.printf("Best candidate is %s with total %d points.%n",
                bestUser, candidatesFullInformation.get(bestUser).values().stream().mapToInt(Integer::valueOf).sum());

        System.out.println("Ranking: ");
        candidatesFullInformation.entrySet()
                .stream()
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().entrySet()
                            .stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(c -> System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue()));
                });
    }
}
