import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest1 {
    private Database database;
    @Before
    public void create() throws OperationNotSupportedException {
        database=new Database(1,2,3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldNotBeCreatedWithMoreThanUpperLimitElements() throws OperationNotSupportedException {
        Database database=new Database(new Integer[17]);
    }
    @Test
    public void constructorShouldAddElementsCorrectly() throws OperationNotSupportedException {
        int[]elements=new int[]{1,2,3};
        Database database=new Database(1,2,3);
        Integer[] elements1 = database.getElements();

        Assert.assertEquals(3,elements1.length);
    }
    @Test
    public void addShouldAddElementCorrectly() throws OperationNotSupportedException {
        database.add(4);

        Assert.assertEquals(4,database.getElements().length);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

}
