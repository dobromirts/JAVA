import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        LinkedHashMap<String, HashMap<String,Integer>>singersByVenue=new LinkedHashMap<>();

        String input=scanner.nextLine();
        while (!input.equals("End")){
            //Lepa Brena @Sunny Beach 25 3500
            String[]tokens=scanner.nextLine().split(" ");
            if (tokens.length<4){
                continue;
            }
            String singer=input.substring(0,input.indexOf(" @"));
            //TODO ADD REGEX EXPRESION

            String venue=input.substring(input.indexOf(" @",input.lastIndexOf("")));


            input=scanner.nextLine();
        }
    }
}
