package codeforces.Task13C;

import codeforces.Task_13C;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

public class Task_13CTest {
    @Test
    public void getAnswerTest() throws Exception {
        Task_13C.readInput(new FileInputStream("./src/test/TestInputFiles/Codeforces/Task13C/First_test_data_set.txt"));
        long actual = Task_13C.findAnswer();
        long expected = 4l;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAnswerTest_2() throws Exception {
        Task_13C.readInput(new FileInputStream("./src/test/TestInputFiles/Codeforces/Task13C/Second_test_data_set.txt"));
        long actual = Task_13C.findAnswer();
        long expected = 6000000000l;
        Assert.assertEquals(expected, actual);
    }
}
