import java.io.PrintStream;

public class Book {
    String name;
    String author;
    float price;
    int edition;

    public Book(String name, String author, float price, int edition) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.edition = edition;
    }

    void print() {
        System.out.printf("%-30s %-25s %8.2f %3d%n", name, author, price, edition);
    }

    void printToFile(PrintStream stream) {
        stream.printf("%s;%s;%.2f;%d%n", name, author, price, edition);
    }
}
