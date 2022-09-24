package personal.chris.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InteropTest {

    @Test
    void callKotlin() {
        KotlinTrial tmp = new KotlinTrial();
        int result = tmp.add(5, 3);

        assertEquals(8, result);
    }

}
