package sky.utils;

import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public enum Operator {
    EQUAL("=="),
    NOT_EQUAL("!="),
    GREATER_EQUAL(">="),
    OR("||"),
    AND("&&");

    private final String value;

    @Override
    public String toString(){
        return value;
    }

    private static final Pattern equalPattern = Pattern.compile("^[=]{1,2}$");

    public static Operator getEnum(String operator){
        if(equalPattern.matcher(operator.trim()).find()) return EQUAL;
        if(operator.trim().equals("!=")) return NOT_EQUAL;
        if(operator.trim().equals(">=")) return GREATER_EQUAL;
        return Operator.valueOf(operator.trim().toUpperCase());
    }
}
