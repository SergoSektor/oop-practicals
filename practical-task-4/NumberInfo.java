public final class NumberInfo {
    public static final Integer[] NUMBERS = {42, 7, 0, -8, -15};

    private NumberInfo() {
    }

    public static String describe(int number) {
        if (number == 0) {
            return "0 — ни положительное, ни отрицательное";
        }
        String sign = number > 0 ? "положительное" : "отрицательное";
        String parity = number % 2 == 0 ? "чётное" : "нечётное";
        return number + " — " + sign + ", " + parity;
    }
}
