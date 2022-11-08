import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void addProd() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 Pro", "Apple");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findName() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 Pro", "Apple");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Смартфон");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindName() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 pro", "Apple");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Волшебник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findProd() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 Pro", "Apple");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Boolean expected = true;
        Boolean actual = manager.matches(book1, "Книга");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findTwoProd() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Iphone 11 Pro", "Apple");
        Book book2 = new Book(3, "Книга", 1000, "Гарри Поттер Навсегда", "Дж. Роулинг");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Книга");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindProd() {
        Book book1 = new Book(1, "Книга", 500, "Гарри Поттер", "Дж. Роулинг");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);

        Boolean expected = false;
        Boolean actual = manager.matches(book1, "Роман");
        Assertions.assertEquals(expected, actual);
    }
}
