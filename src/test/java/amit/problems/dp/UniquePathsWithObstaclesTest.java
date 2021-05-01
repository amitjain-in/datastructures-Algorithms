package amit.problems.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UniquePathsWithObstaclesTest {

    @Test
    public void testUniquePathsWithObstacles() {
        UniquePathsWithObstacles upwo = new UniquePathsWithObstacles();
        Assert.assertEquals(upwo.uniquePathsWithObstacles(new int[][]{{1, 0}}), 0);
        Assert.assertEquals(upwo.uniquePathsWithObstacles(new int[][]{{0, 1}}), 0);
        Assert.assertEquals(upwo.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), 2);
        Assert.assertEquals(upwo.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}), 1);
        Assert.assertEquals(upwo.uniquePathsWithObstacles(new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}}), 0);
    }
}