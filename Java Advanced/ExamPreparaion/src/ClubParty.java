import java.util.*;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallsCapacity = Integer.parseInt(scanner.nextLine());


        LinkedHashMap<String,List<String>>peopleForEveryHall=new LinkedHashMap<>();
        Map<String, Integer>companiesByRoom=new HashMap<>();


        String[] tokens = scanner.nextLine().split(" ");
        //The letters represent the halls and the numbers – the people in a single reservation

        ArrayDeque<String>stackForRooms=new ArrayDeque<>();
        ArrayDeque<Integer>stackForPeople=new ArrayDeque<>();
        ArrayDeque<Character>queue=new ArrayDeque<>();

        for (int i = 0; i <tokens.length ; i++) {
            if (!Character.isDigit(tokens[i].charAt(0))){
                stackForRooms.push(tokens[i]);
            }else {
                stackForPeople.push(Integer.parseInt(tokens[i]));
            }

        }
        int stackPeop=stackForPeople.size();



        for (int i = 0; i <stackPeop-1; i++) {
            String currnetHall=stackForRooms.peek();
            if (stackForPeople.isEmpty()){
                System.out.print(currnetHall+" "+ "-> ");
                System.out.println(String.join(", ",peopleForEveryHall.get(currnetHall)));
                break;
            }
            int currentComany=stackForPeople.peek();
            if (!companiesByRoom.containsKey(currnetHall)){
                companiesByRoom.put(currnetHall,currentComany);
                peopleForEveryHall.put(currnetHall,new ArrayList<>());
                peopleForEveryHall.get(currnetHall).add(currentComany+"");
                stackForPeople.pop();
            }else {
                int currnetSum=companiesByRoom.get(currnetHall);

                if (currnetSum+currentComany>hallsCapacity){
                    System.out.print(currnetHall+" "+ "-> ");
                    System.out.println(String.join(", ",peopleForEveryHall.get(currnetHall)));
                    stackForRooms.pop();
                    currnetHall=stackForRooms.peek();
                    if (!companiesByRoom.containsKey(currnetHall)){
                        companiesByRoom.put(currnetHall,currentComany);
                        peopleForEveryHall.put(currnetHall,new ArrayList<>());
                        peopleForEveryHall.get(currnetHall).add(currentComany+"");
                        stackForPeople.pop();
                    }
                }else {
                    companiesByRoom.put(currnetHall,companiesByRoom.get(currnetHall)+currentComany);
                    peopleForEveryHall.get(currnetHall).add(currentComany+"");
                    stackForPeople.pop();
                }
            }
        }

        System.out.println();




    }
}
