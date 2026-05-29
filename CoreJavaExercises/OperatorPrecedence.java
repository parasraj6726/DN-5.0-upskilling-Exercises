// Q8: Operator Precedence
public class OperatorPrecedence {
    public static void main(String[] args) {
        // Multiplication before addition
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1 + "  (* evaluated first -> 10 + 10)");

        // Parentheses override precedence
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2 + "  (parentheses evaluated first -> 15 * 2)");

        // Mixed arithmetic
        int result3 = 100 / 5 + 3 * 4 - 2;
        System.out.println("100 / 5 + 3 * 4 - 2 = " + result3 + "  (/ and * first: 20 + 12 - 2)");

        // Modulus and addition
        int result4 = 7 % 3 + 2 * 4;
        System.out.println("7 % 3 + 2 * 4 = " + result4 + "  (% and * first: 1 + 8)");
    }
}
