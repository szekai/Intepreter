package sky.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterUtilsTest {

    @Test
    void logicalStmtBuilder() {
        String condition = " a |!=| b,c";
        var logic = InterpreterUtils.logicalStmtBuilder(condition);

        assertEquals("(a!=\"b\"&&a!=\"c\")", logic.toString());

        String condition2 = " a |=| b,c";
        var logic2 = InterpreterUtils.logicalStmtBuilder(condition2);

        assertEquals("(a==\"b\"||a==\"c\")", logic2.toString());
    }

    @Test
    void logicalStmtListBuilder() {
    }

    @Test
    void equalityExprListBuilder() {
        var e  = InterpreterUtils.EqualityExprListBuilder("test", Operator.EQUAL, "1,2");
        var result = e.toList();
        assertEquals(2, result.size());
        assertEquals("[test==\"1\", test==\"2\"]", result.toString());
    }

    @Test
    void getStringStream() {
    }
}