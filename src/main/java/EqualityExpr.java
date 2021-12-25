import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EqualityExpr {

    private final String left;
    private final String right;
    private final Operator operator;

    public static EqualityExpr EqualityExprBuilder(String input) {
        Pattern equalPattern = Pattern.compile("\s(=|==)\s");
        Matcher eqMatch = equalPattern.matcher(input);
        Pattern notEqualPattern = Pattern.compile("\s(!=)\s");
        Matcher neqMatch = notEqualPattern.matcher(input);
        if (eqMatch.find()) {
            return new EqualityExpr(input, Operator.EQUAL, equalPattern);
        } else if (neqMatch.find()) {
            return new EqualityExpr(input, Operator.NOTEQUAL, notEqualPattern);
        } else {
            throw new IllegalArgumentException("Incorrect format");
        }
    }

    public static List<EqualityExpr> EqualityExprListBuilder(String left, String operator, String right){
        Operator o = Operator.getEnum(operator);
        String[] rights = right.split(",");
        return Arrays.stream(rights).map(r -> new EqualityExpr(left, o, r)).collect(Collectors.toList());
    }

    private EqualityExpr(String input, Operator operator, Pattern pattern){
        String[] ss = pattern.split(input);
        if (ss.length != 2) throw new IllegalArgumentException("Incorrect format");
        left = ss[0];//TODO to remove "( ) [ ]"
        right = ss[1];
        this.operator = operator;
    }

    private EqualityExpr(String left, Operator operator, String right){
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toString() {
        return left + operator + right;
    }
}
