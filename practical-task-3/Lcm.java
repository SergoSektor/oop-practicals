public class Lcm implements IOperation {
    @Override
    public String getName() {
        return "НОК";
    }

    @Override
    public String getSign() {
        return "НОК";
    }

    @Override
    public int estimate(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a / gcd(a, b) * b);
    }

    private int gcd(int a, int b) {
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
