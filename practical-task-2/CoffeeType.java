public enum CoffeeType {
    ESPRESSO("Эспрессо", 120),
    AMERICANO("Американо", 150),
    CAPPUCCINO("Капучино", 180),
    LATTE("Латте", 200);

    private final String title;
    private final double price;

    CoffeeType(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title;
    }
}
