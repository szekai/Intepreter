import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogicalStmt {

    private final String output;

    public static LogicalStmt logicalStmtBuilder(String statement){
        List<String> ss = Pattern.compile("\\|").splitAsStream(statement).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        List<EqualityExpr> e = EqualityExpr.EqualityExprListBuilder(ss.get(0), ss.get(1), ss.get(2));
        var expr = new Expr<EqualityExpr>();
        return new LogicalStmt(expr.or(e));
    }

    public static List<LogicalStmt> logicalStmtListBuilder(String statement){
        List<String> ss = Pattern.compile("\sAND\s").splitAsStream(statement).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        return ss.stream().map(LogicalStmt::logicalStmtBuilder).collect(Collectors.toList());
    }

    public LogicalStmt(String output){
        this.output = output;
    }
//    public LogicalStmt(String input) {
//        Pattern orPattern = Pattern.compile("\sor\s", Pattern.CASE_INSENSITIVE);
//        Matcher orMatcher = orPattern.matcher(input);
//        Pattern andPattern = Pattern.compile("\sand\s", Pattern.CASE_INSENSITIVE);
//        Matcher andMatcher = andPattern.matcher(input);
//        if(orMatcher.find()){
//            output = orMatcher.replaceFirst(" || ");
//        } else if(andMatcher.find()){
//            output = andMatcher.replaceFirst(" && ");
//        } else {
//            output = input;
//        }
//    }

    @Override
    public String toString(){
        return output;
    }
}
