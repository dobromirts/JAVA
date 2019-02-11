import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequence = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum=0;

        while (!sequence.isEmpty()) {
            int index=Integer.parseInt(scanner.nextLine());

            if (index>=0 && index<sequence.size()){//Vajna proverka dali e v Diapazona
                int element=sequence.get(index);
                sum+=element;
                sequence.remove(index);
                changeListElements(sequence,element);

            }else if (index<0){
                int removed=sequence.get(0);
                int additionIndex=sequence.get(sequence.size()-1);
                sum+=removed;
                sequence.remove(0);
                sequence.add(0,additionIndex);

                for (int i = 0; i <sequence.size() ; i++) {
                    if (removed>=sequence.get(i)){
                        sequence.set(i,sequence.get(i)+removed);
                    }else {
                        sequence.set(i,sequence.get(i)-removed);
                    }
                }
            }else {
                int removed=sequence.get(sequence.size()-1);
                int additionIndex=sequence.get(0);
                sum+=removed;
                sequence.remove(sequence.size()-1);
                sequence.add(sequence.size()-1,additionIndex);

                for (int i = 0; i <sequence.size() ; i++) {
                    if (removed>=sequence.get(i)){
                        sequence.set(i,sequence.get(i)+removed);
                    }else {
                        sequence.set(i,sequence.get(i)-removed);
                    }
                }

            }

        }
        System.out.println(sum);
    }
    public static void changeListElements(List<Integer> bd , int element){
        for (int i = 0; i <bd.size() ; i++) {
            if (bd.get(i)<=element){
                bd.set(i,bd.get(i)+element);
            }else {
                bd.set(i,bd.get(i)-element);
            }
        }
    }
}
