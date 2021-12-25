import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public enum Operator {
    EQUAL(" == "),
    NOTEQUAL (" != "),
    OR(" || "),
    AND(" && ");

    private final String value;

    @Override
    public String toString(){
        return value;
    }

    private static Pattern equalPattern = Pattern.compile("\s(=|==)\s");
    private static Pattern notEqualPattern = Pattern.compile("\s(!=)\s");
    private static Pattern orPattern = Pattern.compile("\sor\s", Pattern.CASE_INSENSITIVE);
    private static Pattern andPattern = Pattern.compile("\sand\s", Pattern.CASE_INSENSITIVE);
    public static Operator getEnum(String operator){
        if(equalPattern.matcher(operator).find()) return Operator.EQUAL;
        if(notEqualPattern.matcher(operator).find()) return Operator.NOTEQUAL;
        if(orPattern.matcher(operator).find()) return Operator.OR;
        if(andPattern.matcher(operator).find()) return Operator.AND;
        return Operator.valueOf(operator);
    }
    public static void main(String[] args) {
        System.out.println(Operator.EQUAL.name());
        System.out.println(Operator.getEnum(" == "));
    }
}
