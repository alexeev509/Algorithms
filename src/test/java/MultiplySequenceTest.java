import maxMultiplication.MultiplySequence;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class MultiplySequenceTest {
    @Test
    public void searchMultiplicationTest_1() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(6, 5, 3, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchMultiplicationTest_2() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence2.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(4, 2);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void searchMultiplicationTest_3() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence3.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(7, 6, 2);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void searchMultiplicationTest_4() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence4.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchMultiplicationTest_5() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence5.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(10, 7, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchMultiplicationTest_6() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence6.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(6, 5, 2, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchMultiplicationTest_7() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence7.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(9, 4, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchMultiplicationTest_8() throws Exception {
        MultiplySequence.readInput(new FileInputStream("./src/test/TestInputFiles/maxMultiplySequence8.txt"));
        List<Integer> actual = MultiplySequence.searchMultiplication();
        List<Integer> expected = Arrays.asList(5, 3, 2);
        Assert.assertEquals(expected, actual);
    }
}
