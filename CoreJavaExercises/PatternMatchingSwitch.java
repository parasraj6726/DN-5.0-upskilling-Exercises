// Q30: Pattern Matching for switch (Java 21)
public class PatternMatchingSwitch {

    static String describe(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer with value: " + i;
            case String s  -> "String with value: \"" + s + "\" (length=" + s.length() + ")";
            case Double d  -> "Double with value: " + d;
            case Long l    -> "Long with value: " + l;
            case null      -> "null value";
            default        -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(42));
        System.out.println(describe("Hello Java 21"));
        System.out.println(describe(3.14));
        System.out.println(describe(100L));
        System.out.println(describe(null));
        System.out.println(describe(true));
    }
}
