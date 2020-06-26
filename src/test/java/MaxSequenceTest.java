import maxSummSunsequence.MaxSequence;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class MaxSequenceTest {

    @Test
    public void findMaxSubSequenceTest() throws Exception {
        MaxSequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxSubsequence.txt"));
        List<Integer> actual = MaxSequence.findMaxSubSequence();
        List<Integer> expected= Arrays.asList(8,6,4);
        Assert.assertEquals(actual,expected);
    }
}
