package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    private int id;
    private  String title;
    private  String author;
    private  boolean onLoan;
    private Borrower borrower;

    public Book() {
    }

    public Book(String title, String author, boolean onLoan, Borrower borrower) {
        this.title = title;
        this.author = author;
        this.onLoan = onLoan;
        this.borrower = borrower;
    }


    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name="on_loan")
    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id" , nullable= true)
    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
