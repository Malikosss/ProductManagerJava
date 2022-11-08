import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    @Test
    public void addFile() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 Pro", "Apple");
        ProductRepository repo = new ProductRepository();
        repo.addProduct(book1);
        repo.addProduct(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteId() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 Pro", "Apple");
        ProductRepository repo = new ProductRepository();
        repo.addProduct(book1);
        repo.addProduct(smartphone1);
        repo.deleteID(1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
