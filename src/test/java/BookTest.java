import models.Book;
import models.Borrower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;
    Borrower borrower;

    @Before
    public void before(){
        book = new Book("Kama-sutra", "Tomas Turbado", false, null);
        borrower = new Borrower("Shaun");
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

    @Test
    public void hasAuthor() {
        assertEquals("Tomas Turbado", book.getAuthor());
    }

    @Test
    public void canSetAuthor(){
        book.setAuthor("Pepa pig");
        assertEquals("Pepa pig", book.getAuthor());
    }

    @Test
    public void hasOnLoanStatus(){
        assertEquals(false, book.isOnLoan());
    }

    @Test
    public void canSetOnLoanStatus(){
        book.setOnLoan(true);
        assertEquals(true, book.isOnLoan());
    }

    @Test
    public void hasBorrower(){
        assertEquals(null, book.getBorrower());
    }

    @Test
    public void canSetBorrower(){
        book.setBorrower(borrower);
        assertEquals("Shaun", book.getBorrower().getName());
    }
}
