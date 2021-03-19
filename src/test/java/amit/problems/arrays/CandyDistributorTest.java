package amit.problems.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static amit.problems.arrays.CandyDistributor.candiesNew;

public class CandyDistributorTest {

    @DataProvider
    public Object[][] dpTestCandiesNew() {
        return new Object[][]{
                {new int[]{4, 6, 4, 5, 6, 2}, 10},
                {new int[]{6, 6, 2, 3, 1}, 7},
                {new int[]{1, 6, 6, 2, 3, 1}, 9},
                {new int[]{2, 4, 3, 5, 2, 6, 4, 5}, 12},
                {new int[]{3, 2, 1}, 6},
                {new int[]{1, 2, 2}, 4},
                {new int[]{1, 2, 3}, 6},
                {new int[]{1, 1, 1}, 3},
                {new int[]{1, 2, 87, 87, 87, 2, 1}, 13},

        };
    }

    @Test(dataProvider = "dpTestCandiesNew")
    public void testCandiesNew(int[] arr, long output) {
        Assert.assertEquals(candiesNew(arr), output);
    }
}