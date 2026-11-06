public class Div implements IOperation {
    @Override
    public String getName() {
        return "DIV";
    }

    @Override
    public String getSign() {
        return "DIV";
    }

    @Override
    public int estimate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a / b;
    }
}
