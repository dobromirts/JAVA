import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        List<String>names=new ArrayList<>();


        names.add("Vasko");//Posledna pociziq
        names.add("shosho");
        names.remove("shosho");

        for (String name : names) {
            System.out.println(names);
        }

    }
}
