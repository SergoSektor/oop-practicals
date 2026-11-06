public class Gcd implements IOperation {
    @Override
    public String getName() {
        return "НОД";
    }

    @Override
    public String getSign() {
        return "НОД";
    }

    @Override
    public int estimate(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        return x;
    }
}
