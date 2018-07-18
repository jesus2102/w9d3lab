package db;

import models.Book;
import models.Borrower;


public class Seeds {
    public static  void seedData(){
        DBHelper.deleteAll(Book.class);
        DBHelper.deleteAll(Borrower.class);


    
        Borrower borrower1 = new Borrower("Shaun");
        DBHelper.save(borrower1);
        Borrower borrower2 = new Borrower("Jesus");
        DBHelper.save(borrower2);

        Book book1 = new Book("Tin Drum" , "Gunter Grass", false, null);
        DBHelper.save(book1);
        Book book2 = new Book("IT", "Stephen King", true, borrower2);
        DBHelper.save(book2);

    }
}