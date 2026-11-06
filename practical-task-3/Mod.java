public class Mod implements IOperation {
    @Override
    public String getName() {
        return "MOD";
    }

    @Override
    public String getSign() {
        return "MOD";
    }

    @Override
    public int estimate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a % b;
    }
}
