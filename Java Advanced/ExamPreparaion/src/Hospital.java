import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        Map<String, String[][]> departmens = new HashMap<>();
        Map<String, TreeSet<String>> doctorsAndPariens = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Output")) {
            String[] tokens = input.split("\\s+");
            String departmen = tokens[0];
            String doctor = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            if (!departmens.containsKey(departmen)){
                departmens.put(departmen,new String[20][3]);
            }

            boolean patiendAdded=false;
            for (int i = 0; i <departmens.get(departmen).length ; i++) {
                for (int j = 0; j <departmens.get(departmen)[i].length ; j++) {
                    if (departmens.get(departmen)[i][j]==null){
                        departmens.get(departmen)[i][j]=patient;
                        patiendAdded=true;
                        break ;
                    }
                }
                if (patiendAdded){
                    break;
                }
            }

            if (!doctorsAndPariens.containsKey(doctor)){
                doctorsAndPariens.put(doctor,new TreeSet<>());
            }
            if (patiendAdded) {
                doctorsAndPariens.get(doctor).add(patient);
            }


            input = scanner.nextLine();
        }


        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            String[]tokens=commands.split("\\s+");
            if (tokens.length==1){
                String departmen=tokens[0];
//                Arrays.stream(departmens.get(departmen)).forEach(e->{
//                    Arrays.stream(e).filter(Objects::nonNull).forEach(System.out::println);
//                });
                for (int i = 0; i <departmens.get(departmen).length ; i++) {
                    for (int j = 0; j <departmens.get(departmen)[i].length ; j++) {
                        if (departmens.get(departmen)[i][j]!=null){
                            System.out.println(departmens.get(departmen)[i][j]);
                        }
                    }
                }

            }else if (tokens.length==2){
                if (Character.isDigit(tokens[1].charAt(0))){
                    String departmen=tokens[0];
                    int room=Integer.parseInt(tokens[1])-1;

                    String[]roomPatiens=departmens.get(departmen)[room];
                    Arrays.stream(roomPatiens).filter(Objects::nonNull).sorted(String::compareTo).forEach(System.out::println);

                }else {
                    String doctor=tokens[0]+" "+tokens[1];

                    doctorsAndPariens.get(doctor).forEach(System.out::println);
                }
            }


            commands = scanner.nextLine();
        }
    }
}
