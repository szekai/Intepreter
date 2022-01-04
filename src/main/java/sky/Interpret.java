package sky;

import sky.utils.Expr;
import sky.utils.InterpreterUtils;
import sky.vo.Expression;

import java.util.List;
import java.util.stream.Stream;

public class Interpret {
    public static List<Expression.Condition> convert(String statement) {
        return InterpreterUtils.getStringStream(statement, "[\\[\\]]")
                .map(l0 -> l0.split("\s*->\s*"))
                .map(l1 -> new Expression.Condition(getResult(l1[0]), getAction(l1)))
                .toList();
    }

    private static String getResult(String input){
        Stream<String> l2 =  InterpreterUtils.getStringStream(input, "\sAND\s")
                .map(l3 -> InterpreterUtils.getStringStream(l3, "\sOR\s"))
                .map(InterpreterUtils::logicalStmtListBuilder)
                // merge the l3 with ||
                .map(Expr::or);
        return Expr.and(l2); // merge the l2 with &&

    }

    private static String getAction(String[] split){
        return split.length == 1 ? "PROCEED" : split[1];
    }

}
