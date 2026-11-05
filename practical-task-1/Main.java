import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[12];

        books[0] = new Book("Отец Сергий", "Лев Толстой", 500, 5);
        books[1] = new Book("Детство", "Максим Горький", 700, 4);
        books[2] = new Book("В людях", "Максим Горький", 300, 1);
        books[3] = new Book("Код да Винчи", "Дэн Браун", 500, 2);
        books[4] = new Book("Вишнёвый сад", "Антон Чехов", 200, 1);
        books[5] = new Book("Мастер и Маргарита", "Михаил Булгаков", 650, 3);
        books[6] = new Book("Преступление и наказание", "Фёдор Достоевский", 550, 2);
        books[7] = new Book("Война и мир", "Лев Толстой", 900, 1);
        books[8] = new Book("Анна Каренина", "Лев Толстой", 750, 4);
        books[9] = new Book("Тихий Дон", "Михаил Шолохов", 800, 2);
        books[10] = new Book("Собачье сердце", "Михаил Булгаков", 350, 1);
        books[11] = new Book("Евгений Онегин", "Александр Пушкин", 400, 3);

        System.out.println("Исходный массив:");
        print(books);

        sortByName(books);
        System.out.println("\nСортировка по названию:");
        print(books);

        sortByPrice(books);
        System.out.println("\nСортировка по цене (по убыванию):");
        print(books);

        sortByEdition(books);
        System.out.println("\nСортировка по номеру издания:");
        print(books);

        try (PrintStream out = new PrintStream(new File("books.txt"))) {
            for (Book book : books) {
                book.printToFile(out);
            }
            System.out.println("\nМассив записан в файл: " + new File("books.txt").getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void print(Book[] books) {
        for (Book book : books) {
            book.print();
        }
    }

    private static void sortByName(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].name.compareTo(books[minIndex].name) < 0) {
                    minIndex = j;
                }
            }
            Book temp = books[i];
            books[i] = books[minIndex];
            books[minIndex] = temp;
        }
    }

    private static void sortByPrice(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].price > books[maxIndex].price) {
                    maxIndex = j;
                }
            }
            Book temp = books[i];
            books[i] = books[maxIndex];
            books[maxIndex] = temp;
        }
    }

    private static void sortByEdition(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].edition < books[minIndex].edition) {
                    minIndex = j;
                }
            }
            Book temp = books[i];
            books[i] = books[minIndex];
            books[minIndex] = temp;
        }
    }
}
