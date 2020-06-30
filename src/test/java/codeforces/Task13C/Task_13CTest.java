package codeforces.Task13C;

import codeforces.Task_13C;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

public class Task_13CTest {
    @Test
    public void getAnswerTest() throws Exception {
        Task_13C.readInput(new FileInputStream("./src/test/TestInputFiles/Codeforces/Task13C/First_test_data_set.txt"));
        int actual = Task_13C.findAnswer();
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
}
