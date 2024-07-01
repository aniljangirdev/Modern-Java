package ch2;

public class Prog2 {
    public static void main(String[] args) {
        Adder adder = (a, b) -> a + b;
        // SmartAdder is not function interface
        int add = adder.add(10, 20);
        System.out.println(add);
    }
}
interface Adder {
    int add(int a, int b);
}

interface SmartAdder extends Adder {

    @Override
    int add(int a, int b);

    int add(double a, double b);
}


