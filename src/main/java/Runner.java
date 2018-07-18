import db.DBHelper;
import models.Book;
import models.Borrower;

import java.util.List;

public class Runner {
    public static void main(String[] args) {




        // Borrower CRUD tests

        Borrower borrower = borrower = new Borrower("Bob");
        DBHelper.save(borrower);
        borrower.setName("Bill");
        DBHelper.update(borrower);

        Borrower borrower2 = new Borrower();
        DBHelper.save(borrower2);
        DBHelper.delete(borrower2);

        Borrower foundBorrower = DBHelper.findById(1, Borrower.class);

        List<Borrower> allBorrowers = DBHelper.getAll(Borrower.class);


        // Book CRUD tests

        Book book = new Book("Harry Potter", "Bob", true, borrower);
        DBHelper.save(book);
        book.setAuthor("JK Rowling");
        DBHelper.update(book);

        Book book3 = new Book("Harry Potter", "Bob", true, borrower);
        DBHelper.save(book3);

        Book book2 = new Book("Harry Potter", "Bob", true, null);
        DBHelper.save(book2);
        DBHelper.delete(book2);

        Book foundBook = DBHelper.findById(1, Book.class);

        List<Book> allBooks = DBHelper.getAll(Book.class);
        
        
        
        
        
    }
}
