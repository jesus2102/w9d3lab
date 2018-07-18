import models.Book;
import org.junit.Before;

public class BookTest {

    Book book;

    @Before
    public void before(){
        book = new Book("Kama-sutra", "Tomas Turbado")
    }
}
