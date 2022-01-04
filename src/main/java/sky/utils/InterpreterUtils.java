package sky.utils;

import sky.vo.Expression;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class InterpreterUtils {
    public static Expression.Logical logicalStmtBuilder(String statement) {
        var expr = new Expr();
        var ss = getStringStream(statement, "\\|").toList();
        if (ss.size() == 3) {
            var o = Operator.getEnum(ss.get(1));
            var e = EqualityExprListBuilder(ss.get(0), o, ss.get(2));
            if (o == Operator.EQUAL)
                return new Expression.Logical(expr.or(e));
            else return new Expression.Logical(expr.and(e));
        } else return new Expression.Logical(statement);
    }

    public static Stream<Expression.Logical> logicalStmtListBuilder(Stream<String> statement) {
        return statement.map(s -> s.replace("(", "").replace(")", ""))
                .map(InterpreterUtils::logicalStmtBuilder);
    }

    public static Stream<Expression.Equality> EqualityExprListBuilder(String left, Operator o, String right) {
        return InterpreterUtils.getStringStream(right, "\s*,\s*").map(r -> new Expression.Equality(left, o, r));
    }

    public static Stream<String> getStringStream(String statement, String pattern) {
        return Pattern.compile(pattern).splitAsStream(statement).filter(s -> !s.isEmpty() && !s.isBlank()).map(String::trim);
    }
}
