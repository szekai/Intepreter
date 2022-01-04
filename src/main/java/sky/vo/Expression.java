package sky.vo;

import sky.utils.Operator;

public interface Expression {
    record Condition(String output, String action) implements Expression {
    }

    record Equality(String left, Operator operator, String right) implements Expression {

        @Override
        public String toString() {
            return left + operator + "\"" + right + "\"";
        }
    }

    record Logical(String output) implements Expression {

        @Override
        public String toString() {
            return output;
        }
    }
}
