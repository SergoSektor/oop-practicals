public class UI {
    public static void main(String[] args) {
        IOperation[] operations = {
                new Div(),
                new Mod(),
                new Gcd(),
                new Lcm()
        };

        int a = 120;
        int b = 24;

        for (IOperation operation : operations) {
            System.out.println(operation.getName());
            System.out.printf("%d %s %d = %d%n", a, operation.getSign(), b, operation.estimate(a, b));
            System.out.println();
        }
    }
}
