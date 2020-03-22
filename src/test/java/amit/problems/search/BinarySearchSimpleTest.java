package amit.problems.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import static amit.problems.search.BinarySearchSimple.binarySearch;
import static org.testng.Assert.*;

public class BinarySearchSimpleTest {

    @Test
    public void testBinarySearch() {
        Assert.assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5}, 3), 2);//Middle
        Assert.assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5}, 1), 0);//Start
        Assert.assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5}, 5), 4);//End
        Assert.assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5}, 6), -1);//Not found
    }
}