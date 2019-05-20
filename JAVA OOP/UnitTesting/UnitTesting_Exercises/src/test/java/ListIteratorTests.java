import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator listIterator;
    private static final String[]DATA=new String[]{"one","two","three"};
    @Before
    public void createListIterator() throws OperationNotSupportedException {
        this.listIterator=new ListIterator(DATA);
    }



    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        ListIterator listIterator=new ListIterator(null);
    }

    @Test
    public void constructorShouldSetElementsCorrectly(){
        Assert.assertEquals(DATA[0],this.listIterator.print());
    }

    @Test
    public void printShouldReturnCorrectElement(){
        Assert.assertEquals(DATA[0],this.listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionOnEmptyCollection() throws OperationNotSupportedException {
        ListIterator listIterator=new ListIterator();
        listIterator.print();
    }

    @Test
    public void hasNextShouldReturnFalseOnEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator=new ListIterator();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnTrueWithCorrectIndex(){
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void moveShouldMovedCorrectlyToTheNextElement(){
        this.listIterator.move();
        Assert.assertEquals("Two",this.listIterator.print());
    }


}
