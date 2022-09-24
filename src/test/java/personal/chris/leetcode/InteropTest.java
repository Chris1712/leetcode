package personal.chris.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InteropTest {

    @Test
    void callKotlin() {
        Temp tmp = new Temp();
        int result = tmp.add(5, 3);

        assertEquals(8, result);
    }

}
