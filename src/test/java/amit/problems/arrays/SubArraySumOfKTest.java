package amit.problems.arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubArraySumOfKTest {

    @Test
    public void testSubArraySumBruteForce() {
        SubArraySumOfK subArraySumOfK = new SubArraySumOfK();
        Assert.assertEquals(subArraySumOfK.subArraySumBruteForce(new int[]{2, 3, 4, 1}, 4), 1);
        Assert.assertEquals(subArraySumOfK.subArraySumBruteForce(new int[]{2, 3, -4, 1}, 2), 2);
    }

    @Test
    public void testSubArraySumOptimised() {
        SubArraySumOfK subArraySumOfK = new SubArraySumOfK();
        Assert.assertEquals(subArraySumOfK.subArraySumOptimised(new int[]{2, 3, 4, 1}, 4), 1);
        Assert.assertEquals(subArraySumOfK.subArraySumOptimised(new int[]{2, 3, -4, 1}, 2), 2);
        Assert.assertEquals(subArraySumOfK.subArraySumOptimised(new int[]{2, 5, 5}, 10), 1);
    }
}