package codeforces.Task10D;

import codeforces.Task_10D;
import org.junit.Test;

import java.io.FileInputStream;

public class Task_10DTest {
    @Test
    public void getAnswerSequenceTest_1() throws Exception {
        Task_10D.readInput(new FileInputStream("./src/test/TestInputFiles/Codeforces/Task10D/First_test_data_set.txt"));
        Task_10D.getAnswerSequence();
    }


    @Test
    public void getAnswerSequenceTest_2() throws Exception {
        Task_10D.readInput(new FileInputStream("./src/test/TestInputFiles/Codeforces/Task10D/First_test_data_set_2.txt"));
        Task_10D.getAnswerSequence();
    }
}
