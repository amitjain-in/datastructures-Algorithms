package amit.problems.strings;

import org.testng.Assert;
import org.testng.annotations.Test;

import static amit.problems.strings.MostCommonWord.mostCommonWord;

public class MostCommonWordTest {

    @Test
    public void testMostCommonWord() {
        Assert.assertEquals(mostCommonWord("Bob. hIt, baLl", new String[] {"bob", "hit"}), "ball");
    }
}