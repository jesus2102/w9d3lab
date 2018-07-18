import models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void before(){
        book = new Book("Kama-sutra", "Tomas Turbado", false, null);
    }

    @Test
    public void hasTitle(){
        assertEquals("Kama-sutra", book.getTitle());
    }

    @Test
    public void canSetTitle(){
        book.setTitle("Catcher in the rye");
        assertEquals("Catcher in the rye", book.getTitle());
    }
}
