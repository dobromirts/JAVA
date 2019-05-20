import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {
    private Database database;
    @Before
    public void create() throws OperationNotSupportedException {
        Person person=new Person(1,"Gosho");
        database=new Database(person);
    }

    @Test
    public void addMethodShouldAddPersonCorrectly() throws OperationNotSupportedException {
        Person person=new Person(2,"Ivan");
        database.add(person);

        Assert.assertEquals(2,database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowExceptionIfPersonIsNull() throws OperationNotSupportedException {
        database.add(null);
    }
}
