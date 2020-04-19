package amit.problems.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import static amit.problems.search.RotatedArraySearch.findPivot;

public class RotatedArraySearchTest {

    @Test
    public void testFindPivot() {
        Assert.assertEquals(findPivot(new int[]{4, 1, 3}), 1);
        Assert.assertEquals(findPivot(new int[]{1, 2, 3}), 0);
        Assert.assertEquals(findPivot(new int[]{3, 2, 1}), 2);
        Assert.assertEquals(findPivot(new int[]{1}), 0);
        Assert.assertEquals(findPivot(new int[]{1, 1}), 0);
        Assert.assertEquals(findPivot(new int[]{1, 2}), 0);
        Assert.assertEquals(findPivot(new int[]{1, 1, 2}), 0);
        Assert.assertEquals(findPivot(new int[]{2, 1}), 1);
        Assert.assertEquals(findPivot(new int[]{1, 2, 1}), 2);
        Assert.assertEquals(findPivot(new int[]{1, 2, 3}), 0);
        Assert.assertEquals(findPivot(new int[]{9, 10, 4, 5, 7, 8}), 2);//Fails
        Assert.assertEquals(findPivot(new int[]{9, 3, 4, 5, 7, 8}), 1);
        Assert.assertEquals(findPivot(new int[]{9, 10, 11, 12, 7, 8}), 4);
        Assert.assertEquals(findPivot(new int[]{2,2,2,0,2,2}), 3);
    }
}