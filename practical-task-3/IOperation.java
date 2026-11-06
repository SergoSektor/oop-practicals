public interface IOperation {
    String getName();

    String getSign();

    int estimate(int a, int b);
}
