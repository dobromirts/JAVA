package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {



        Constructor constructor=BlackBoxInt.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt=(BlackBoxInt)constructor.newInstance();

        Method[] methods=blackBoxInt.getClass().getDeclaredMethods();

        Field innerValue=blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();

        while (!input.equals("END")){
            String[]tokens=input.split("_");
            String command=tokens[0];
            int value = Integer.parseInt(tokens[1]);


            Method filteredMethods = Arrays.stream(methods).filter(f -> f.getName().equals(command)).findFirst().orElse(null);
            filteredMethods.setAccessible(true);
            filteredMethods.invoke(blackBoxInt,value);
            System.out.println(innerValue.get(blackBoxInt));




            input=scanner.nextLine();
        }

    }
}
