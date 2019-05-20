package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {

		String name = RichSoilLand.class.getName();

		Class clazz=Class.forName(name);
		Field[]fields=clazz.getDeclaredFields();

		Scanner scanner=new Scanner(System.in);
		String input=scanner.nextLine();

		while (!input.equals("HARVEST")){
			String finalInput = input;
			Field[]requestedFields= Arrays.stream(fields).filter(f->
				Modifier.toString(f.getModifiers()).equals(finalInput)).toArray(Field[]::new);

			if (requestedFields.length!=0){
				Arrays.stream(requestedFields).forEach(f-> System.out.println(String.format("%s %s %s",Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName())));
			}else {
				Arrays.stream(fields).forEach(f-> System.out.println(String.format("%s %s %s",Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName())));
			}

			input=scanner.nextLine();
		}

	}
}
