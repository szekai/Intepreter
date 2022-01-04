package sky.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExprTest {

    @Test
    void or() {
        List<String> l = List.of("a","b","c");
        String expected ="(a||b||c)";
        String s = Expr.or(l);
        assertEquals(expected, s);

        String s2 = Expr.or(l.stream());
        assertEquals(expected, s2);
    }

    @Test
    void and() {
        List<String> l = List.of("a","b","c");
        String expected ="(a&&b&&c)";
        String s = Expr.and(l);
        assertEquals(expected, s);

        String s2 = Expr.and(l.stream());
        assertEquals(expected, s2);

    }
}