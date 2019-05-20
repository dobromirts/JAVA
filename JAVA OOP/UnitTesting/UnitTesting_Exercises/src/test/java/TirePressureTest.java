import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

public class TirePressureTest {


    @Test
    public void alarmIsOnWhenPressureIsLowerThanLowerLimit() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm=new Alarm();
        Sensor sensor= Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);

        Field field=Alarm.class.getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm,sensor);


        //ako ne beshe vutreshno poleto ami dadeno kato dependency otvun v construktora
        //Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        //Alarm alarm=new Alarm(sensor)
        //i minavam samo s mockinga

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }


    @Test
    public void alarmIsOnWhenPressureIsGreaterThenUpperLimit() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm=new Alarm();
        Sensor sensor= Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);

        Field field=Alarm.class.getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm,sensor);


        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }


}
