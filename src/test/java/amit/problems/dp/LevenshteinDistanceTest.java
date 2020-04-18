package amit.problems.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LevenshteinDistanceTest {

    @Test
    public void testDistance() {
        LevenshteinDistance ld = new LevenshteinDistance();
        Assert.assertEquals(ld.distance("hellow", "hellop"), 1);
        Assert.assertEquals(ld.distance("hellow", "hellow"), 0);
        Assert.assertEquals(ld.distance("hello", "hello1"), 1);
        Assert.assertEquals(ld.distance("hello", "hello12"), 2);
        Assert.assertEquals(ld.distance("hello12", "hello"), 2);
        Assert.assertEquals(ld.distance("hellow", "hello"), 1);
        Assert.assertEquals(ld.distance("whello", "hello"), 1);
        Assert.assertEquals(ld.distance("helelo", "hello"), 1);
        Assert.assertEquals(ld.distance("hello", "helelo"), 1);
    }
}