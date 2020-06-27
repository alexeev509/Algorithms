import maxMultiplication.MultiplySequence;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.List;

public class MultiplySequenceTest {
    @Test
    public void searchMultiplicationTest() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
//        List<Integer> expected= Arrays.asList(8,6,4);
//        Assert.assertEquals(actual,expected);
    }
}
