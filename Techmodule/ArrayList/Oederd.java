import java.util.*;
import java.util.stream.Collectors;

public class Oederd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        List<String> banani=new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String qbulki=scanner.nextLine();
            banani.add(qbulki);
        }
        Collections.sort(banani);

        for (int i = 0; i < banani.size(); i++) {
            System.out.println(i+"."+banani.get(i));
        }
    }
}
