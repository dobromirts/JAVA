import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class DatabaseTest {
    public static final Integer[] INITIAL_ELEMENTS=new Integer[]{1,2,3,4,};


    @Test (expected = OperationNotSupportedException.class)
     public void constructorShouldThrowExceptionWithLessThanOneElement() throws OperationNotSupportedException {
        Database db=new Database();
    }



    @Test (expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Database db=new Database(new Integer[17]);
    }

    public void constructingDatabaseShouldIncreaseElementsCount() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database db=new Database(DatabaseTest.INITIAL_ELEMENTS);

        Field  elementsCounts=Database.class.getDeclaredField("elementsCount");
        elementsCounts.setAccessible(true);
        int fieldCurrentValue=elementsCounts.getInt(db); //Db -> podavame obekta na koito vzimame stionosta na tova pole

        Assert.assertEquals(DatabaseTest.INITIAL_ELEMENTS.length,fieldCurrentValue);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowException() throws OperationNotSupportedException {
        Database db=new Database(INITIAL_ELEMENTS);
        db.add(null);
    }

    public void addElementShouldIncreaseElementCount() throws OperationNotSupportedException {
        Database db=new Database(INITIAL_ELEMENTS);
        db.add(12);

        Assert.assertEquals(db.getElements().length,INITIAL_ELEMENTS.length+1);

    }


}
