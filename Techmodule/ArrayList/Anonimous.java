import java.util.*;
import java.util.stream.Collectors;

public class Anonimous {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String line = scanner.nextLine();
        List<String>result=new ArrayList<>();

        while (!line.equals("3:1")) {
            String[] cmdArgs = line.split(" ");
            String comName = cmdArgs[0];
            int startIndex = Math.min(Integer.parseInt(cmdArgs[1]), names.size() - 1);
            startIndex = Math.min(0, startIndex);
            int endIndex=Integer.parseInt(cmdArgs[2]);

            if (comName.equals("merge")) {
                endIndex = Math.min(Integer.parseInt(cmdArgs[2]), names.size() - 1);
                endIndex = Math.max(0, endIndex);

                if (startIndex>0){
                    result.addAll(names.subList(0,startIndex));//Vajno s sublist
                }
                String merged=names.subList(startIndex,endIndex+1).stream().reduce((res,el)->res+el).get();
                result.add(merged);
                if (endIndex+1<names.size()){
                    result.addAll(names.subList(endIndex+1,names.size()));
                }
                names=result;
            }else {

                String element=names.get(startIndex);
                endIndex=Math.min(endIndex,element.length());
                int symbold=element.length()/endIndex;

                int lastElementLenght=symbold+element.length()%endIndex;
                int parts=element.length()-lastElementLenght;
                for (int i = 0; i <parts && element.length()>0; i++) {

                    result.add(element.substring(0,symbold));
                    element=element.substring(symbold);
                }
                if (!element.isEmpty()){
                    result.add(element);
                }
                names.remove(startIndex);
                names.addAll(startIndex,result);


            }
            line = scanner.nextLine();
        }
        names.forEach(e-> System.out.print(e+ " "));
    }
}
