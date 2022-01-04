package sky.utils;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Expr {
    public static <E> String or(Collection<E> ls) {
        return joining.apply(ls, Operator.OR.toString());
    }

    public static <E> String or(Stream<E> ls) {
        return joinStream().apply(ls, Operator.OR.toString());
    }

    public static <E> String and(Collection<E> ls) {
        return joining.apply(ls, Operator.AND.toString());
    }

    public static <E> String and(Stream<E> ls) {
        return joinStream().apply(ls, Operator.AND.toString());
    }

    private static final BiFunction<Collection<?>, String, String> joining = (e,y) -> joinStream().apply(e.stream(), y);

    private static BiFunction<Stream<?>, String, String> joinStream() {
        return (e,y) -> e
                .map(Object::toString)
                .collect(Collectors.joining(y, "(", ")"));
    }


}
