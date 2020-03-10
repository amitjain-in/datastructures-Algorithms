package amit.problems.digits;

import org.testng.Assert;

public class DigitHelperTest {

    @org.testng.annotations.Test
    public void testGetDigitCount() {
        Assert.assertEquals(DigitHelper.getDigitCount(10), 2);
        Assert.assertEquals(DigitHelper.getDigitCount(100), 3);
        Assert.assertEquals(DigitHelper.getDigitCount(1), 1);
        Assert.assertEquals(DigitHelper.getDigitCount(9), 1);
        Assert.assertEquals(DigitHelper.getDigitCount(100_000_000), 9);
        Assert.assertEquals(DigitHelper.getDigitCount(1_000_000_000), 10);
    }

    @org.testng.annotations.Test
    public void testGetDigitSum() {
        Assert.assertEquals(DigitHelper.getDigitSum(10), 1);
        Assert.assertEquals(DigitHelper.getDigitSum(100), 1);
        Assert.assertEquals(DigitHelper.getDigitSum(23), 5);
        Assert.assertEquals(DigitHelper.getDigitSum(9), 9);
        Assert.assertEquals(DigitHelper.getDigitSum(12000), 3);
        Assert.assertEquals(DigitHelper.getDigitSum(123_456_789), 45);
    }
}