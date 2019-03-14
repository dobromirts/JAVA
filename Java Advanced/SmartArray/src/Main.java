import smartArray.SmartArray;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray=new SmartArray();

        System.out.println(smartArray.size());

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);

        smartArray.add(5);

        int element=smartArray.removeAt(0);
        System.out.println(element);

        System.out.println(smartArray.contains(2));

        smartArray.forEach(System.out::println);


    }
}
