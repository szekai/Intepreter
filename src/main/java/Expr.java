import java.util.Collection;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Expr<E> {
    public String or(Collection<E> ls) {
        return joining.apply(ls, Operator.OR.toString());
    }

    public String and(Collection<E> ls) {
        return joining.apply(ls, Operator.AND.toString());
    }

    private final BiFunction<Collection<E>, String, String> joining = (e,y) -> e.stream()
            .map(Object::toString)
            .collect(Collectors.joining(y, "(", ")"));
}
