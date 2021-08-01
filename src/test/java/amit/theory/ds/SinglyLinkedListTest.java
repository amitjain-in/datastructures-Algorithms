package amit.theory.ds;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;

public class SinglyLinkedListTest {

    private static final Character a = 'A';
    private static final Character b = 'B';
    private static final Character c = 'C';

    @Test
    public void testSingle() {
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        list.add(a);
        Assert.assertEquals(list.getHead().getData(), a);
        Assert.assertEquals(list.getTail().getData(), a);
        Assert.assertTrue(list.remove(a));//Remove only element
        assertNull(list.getHead());
        assertNull(list.getTail());
        Assert.assertFalse(list.remove(a));
    }

    @Test
    public void testDouble() {
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        list.add(a);
        list.add(b);
        Assert.assertEquals(list.getHead().getData(), a);
        Assert.assertEquals(list.getHead().getNext().getData(), b);
        Assert.assertEquals(list.getTail().getData(), b);
        Assert.assertTrue(list.remove(a));//Removed from head
        Assert.assertEquals(list.getHead().getData(), b);
        Assert.assertEquals(list.getTail().getData(), b);
        list.add(c);
        Assert.assertEquals(list.getHead().getData(), b);
        Assert.assertEquals(list.getTail().getData(), c);
        Assert.assertTrue(list.remove(c));//Removed from tail
        Assert.assertEquals(list.getHead().getData(), b);
        Assert.assertEquals(list.getTail().getData(), b);
    }

    @Test
    public void testTriple() {
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        Assert.assertEquals(list.getHead().getData(), a);
        Assert.assertEquals(list.getHead().getNext().getData(), b);
        Assert.assertEquals(list.getTail().getData(), c);
        Assert.assertTrue(list.remove(b));//Removed from middle
        Assert.assertEquals(list.getHead().getData(), a);
        Assert.assertEquals(list.getTail().getData(), c);
        Assert.assertFalse(list.remove(b));//False remove
        list.add(b);
        Assert.assertEquals(list.getHead().getData(), a);
        Assert.assertEquals(list.getTail().getData(), b);
        Assert.assertTrue(list.remove(b));//Removed from tail
        Assert.assertEquals(list.getHead().getData(), a);
        Assert.assertEquals(list.getTail().getData(), c);
        list.add(b);
        Assert.assertTrue(list.remove(a));//Removed from head
        Assert.assertEquals(list.getHead().getData(), c);
        Assert.assertEquals(list.getTail().getData(), b);
    }
}