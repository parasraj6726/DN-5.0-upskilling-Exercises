// Q7: Type Casting Example
public class TypeCastingExample {
    public static void main(String[] args) {
        // double to int (narrowing)
        double myDouble = 9.78;
        int myInt = (int) myDouble;
        System.out.println("double " + myDouble + " cast to int: " + myInt);

        // int to double (widening)
        int anotherInt = 5;
        double anotherDouble = (double) anotherInt;
        System.out.println("int " + anotherInt + " cast to double: " + anotherDouble);
    }
}
