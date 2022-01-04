package sky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpretTest {

    @Test
    void convert1() {
        String original2 ="[((Acc.status|!=|001,002 OR Hold.code|=|043 OR Hold.code|!=|044) OR (Hold.amount|>=|100))]";
        var o3 = Interpret.convert(original2);

        String expected = "(((Acc.status!=\"001\"&&Acc.status!=\"002\")||(Hold.code==\"043\")||(Hold.code!=\"044\")||(Hold.amount>=\"100\")))";
        assertEquals(expected, o3.get(0).output());
    }

    @Test
    void convert2(){
        String original1 ="[((Acc.status| =  |001,002 OR Hold.code| =|043) AND (Hold.amount|>=|99.9))]";
        var o = Interpret.convert(original1);

        String expected = "(((Acc.status==\"001\"||Acc.status==\"002\")||(Hold.code==\"043\"))&&((Hold.amount>=\"99.9\")))";
        assertEquals(expected, o.get(0).output());
    }

    @Test
    void convert3(){
        String statement3 = "|a | = | c, d | AND |e | != | f, g |";
        var o2 = Interpret.convert(statement3);

        String expected = "(((a==\"c\"||a==\"d\"))&&((e!=\"f\"&&e!=\"g\")))";
        assertEquals(expected, o2.get(0).output());
    }

    @Test
    void convert4(){
        String stmt = "Default";
        var o = Interpret.convert(stmt);
        assertEquals("Condition[output=((Default)), action=PROCEED]", o.get(0).toString());
    }

    @Test
    void convert5(){
        String original5 ="[Acc.status | = | 002 AND Hold.code|=|040 -> SKIP cbs]";

        var o = Interpret.convert(original5);
        assertEquals("SKIP cbs", o.get(0).action());
    }
}