package amit.problems.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import static amit.problems.search.BinarySearchBounded.sortedBounded;

public class BinarySearchBoundedTest {

    @Test
    public void testSortedBounded() {
        Assert.assertEquals(sortedBounded(new int[]{0, 1, 2, 2, 2, 3, 4}, 2), new int[]{2, 4});//Multiple occurrences in middle
        Assert.assertEquals(sortedBounded(new int[]{0, 1, 2, 2, 2, 3, 4}, 1), new int[]{1, 1});//Single occurrence in middle
        Assert.assertEquals(sortedBounded(new int[]{0, 1, 2, 2, 2, 3, 4}, 0), new int[]{0, 0});//Single occurrence at start
        Assert.assertEquals(sortedBounded(new int[]{0, 0, 2, 2, 2, 3, 4}, 0), new int[]{0, 1});//Multiple occurrence at start
        Assert.assertEquals(sortedBounded(new int[]{0, 1, 2, 2, 2, 3, 4}, 4), new int[]{6, 6});//Single occurrence at end
        Assert.assertEquals(sortedBounded(new int[]{0, 1, 2, 2, 2, 4, 4}, 4), new int[]{5, 6});//Multiple occurrence at end
        Assert.assertEquals(sortedBounded(new int[]{0, 0, 0, 0, 0, 0, 0}, 0), new int[]{0, 6});//Complete array
    }
}