package pr0304Barracks.core.factories;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType)  {
		Class clazz=unitType.getClass();


		Unit unit=null;

		try {
			Class<? extends Unit>unitClass= (Class<? extends Unit>) Class.forName(UNITS_PACKAGE_NAME+unitType);
			Constructor declaredConstructor = unitClass.getDeclaredConstructor();
			unit=(Unit)declaredConstructor.newInstance();

		} catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return  unit;
	}
}
