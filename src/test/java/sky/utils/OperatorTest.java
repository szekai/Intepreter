package sky.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void getEnum() {
        assertEquals(Operator.EQUAL, Operator.getEnum("=="));
        assertEquals(Operator.EQUAL, Operator.getEnum("="));
        assertEquals(Operator.NOT_EQUAL, Operator.getEnum("!="));
        assertEquals(Operator.AND, Operator.getEnum("and"));
        assertEquals(Operator.OR, Operator.getEnum("or"));
    }
}