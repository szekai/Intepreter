import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Interpret {
    public static void main(String[] args) {
        String statement = " a = b AND c = d OR d = c";
        String expected = "((a == b && c == d) || (d == c))";

        String statement2 = "|a | = | c, d |";
        String expected2 = "( a == c || a == d )";

        LogicalStmt logicalStmt = LogicalStmt.logicalStmtBuilder(statement2);
        System.out.println(logicalStmt.toString());


        String statement3 = "|a | = | c, d | AND |e | != | f, g |";
        String expected3 = "( a == c || a == d ) && ( e != f || e != g )";

        List<LogicalStmt> stmtList =  LogicalStmt.logicalStmtListBuilder(statement3);
        stmtList.forEach(System.out::println);
        var expr = new Expr<LogicalStmt>();
        String output = expr.and(stmtList);
        System.out.println(output);
    }
}
