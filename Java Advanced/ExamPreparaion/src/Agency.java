import java.util.*;
import java.util.stream.Collectors;

public class Agency {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]inoutIds=scanner.nextLine().split("\\s+");
        String[]agentsName=scanner.nextLine().split("\\s+");

        ArrayDeque<Integer>ids=new ArrayDeque<>();
        ArrayDeque<String>agents=new ArrayDeque<>();
        ArrayList<Integer>sortedIds=new ArrayList<>();
        for (int i = 0; i <inoutIds.length ; i++) {
            ids.push(Integer.parseInt(inoutIds[i]));
        }
        for (int i = 0; i <agentsName.length ; i++) {
            agents.offer(agentsName[i]);
        }

        String command=scanner.nextLine();
        while (!command.equals("stop")){
            String[] currentCommand=command.split("-");
            String mainCommand=currentCommand[0];
            String additionCommand=currentCommand[1].split(" ")[0];

            switch (mainCommand){
                case "add":
                    String target=currentCommand[1].split(" ")[1];
                    if (additionCommand.equals("ID")){
                        ids.push(Integer.parseInt(target));
                    }else {
                        agents.addLast(target);
                    }
                    break;
                case "remove":
                    if (additionCommand.equals("ID")){
                        Integer removedId=ids.pop();
                        System.out.printf("%s has been removed.%n",removedId);
                    }else {
                        String leftAgent=agents.pollLast();
                        System.out.printf("%s has left the queue.%n",leftAgent);
                    }
                    break;
                case "sort":
                    sortedIds.addAll(ids);
                    sortedIds.sort(Integer::compareTo);

                    ids=ids.stream().sorted((e1,e2)->Integer.compare(e2,e1)).collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }
            command=scanner.nextLine();
        }
        for (String agent : agents) {
            if (ids.isEmpty()){
                System.out.printf("%s does not have an ID.",agents.poll());
                break;
            }
            System.out.printf("%s takes ID number: %s%n",agents.poll(),ids.pop());
        }
        if (!ids.isEmpty()){
            System.out.println("No more agents left.");

            for (Integer id : ids) {
                System.out.printf("ID number: %s",ids.pop());
            }
        }
    }
}
