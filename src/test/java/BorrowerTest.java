import models.Borrower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;

    @Before
    public void before(){
        borrower = new Borrower("Shaun");
    }

    @Test
    public void hasName(){
        assertEquals("Shaun", borrower.getName());
    }

    @Test
    public void canSetName(){
        borrower.setName("Jesus");
        assertEquals("Jesus", borrower.getName());
    }

}
