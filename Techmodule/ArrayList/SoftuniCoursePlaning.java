import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftuniCoursePlaning {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String>shedule= Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        String input=scanner.nextLine();

        while (!input.equals("course start")){
            String[]command=input.split(":");

            if (command[0].equals("Add")){
                if (!shedule.contains(command[1])){
                    shedule.add(command[1]);
                }
            }else if (command[0].equals("Insert")){
                int index=Integer.parseInt(command[2]);

                if (!shedule.contains(command[1])){
                    shedule.add(index,command[1]);
                }
            }else if (command[0].equals("Remove")){
                if (shedule.contains(command[1])){
                    int indexOf=shedule.indexOf(command[1]);
                    shedule.remove(indexOf);
                }
            }else if (command[0].equals("Swap")){
                String lessonWithExer=command[1]+"-Exercise";
                if (shedule.contains(command[1])){
                    if (shedule.contains(command[2])){
                        if (shedule.contains(lessonWithExer)) {

                            int indexOfExer=shedule.indexOf(lessonWithExer);
                            int indexOther=shedule.indexOf(command[2]+1);
                            String tempExer=shedule.get(indexOther);
                            shedule.set(indexOther,lessonWithExer);
                            shedule.set(indexOfExer,tempExer);
                        }
                        String temp=command[1];
                        int indexOfFirst=shedule.indexOf(command[1]);
                        int indexOfSecond=shedule.indexOf(command[2]);
                        shedule.set(indexOfFirst,command[2]);
                        shedule.set(indexOfSecond,temp);
                    }
                }
            }else if (command[0].equals("Exercise")){
                String lessonExer=command[1]+"-Exercise";
                if (shedule.contains(command[1])){
                    if (!shedule.contains(lessonExer)){
                        int indexOfLesson=Integer.parseInt(command[1]);
                        shedule.set(indexOfLesson+1,lessonExer);
                    }
                }else if (!shedule.contains(command[1])){
                    shedule.add(command[1]);
                    shedule.add(lessonExer);
                }
            }



            input=scanner.nextLine();
        }
        for (int i = 0; i <shedule.size() ; i++) {
            System.out.print(i+1 + ".");
            System.out.println(shedule.get(i));
        }
    }
}
