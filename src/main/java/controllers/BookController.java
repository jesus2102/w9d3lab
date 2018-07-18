package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookController {
    
    public BookController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {


        get("/books", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/books/index.vtl");

            List<Book> books = DBHelper.getAll(Book.class);
            model.put("books", books);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        get("/books/new", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/books", (req, res) -> {
            String title = req.queryParams("title");
            String author = req.queryParams("author");


            Book newBook = new Book(title, author, false, null);

            DBHelper.save(newBook);

            res.redirect("/books");
            return null;

        }, new VelocityTemplateEngine());



//        get("/books/:id/edit", (req, res) -> {
//
//            HashMap<String, Object> model = new HashMap<>();
//
//            int bookId = Integer.valueOf(req.params(":id"));
//            Book book = DBHelper.findById(bookId, Book.class);
//            model.put("book", book);
//
//            model.put("template", "templates/books/edit.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//
//        }, new VelocityTemplateEngine());
//
//        post("/books/:id", (req, res) -> {
//
//            Book newBook = new Book();
//
//            int Id = Integer.valueOf(req.params(":id"));
//
//            String title = req.queryParams("title");
//            String author = req.queryParams("author");
//            boolean loanStatus = req.queryParams("is_on_loan");
//
//            newBook.setId(Id);
//            newBook.setTitle(title);
//
//            DBHelper.save(newBook);
//
//            res.redirect("/books");
//            return null;
//
//        }, new VelocityTemplateEngine());
//
//
//
//
        post("books/:id/delete", (req, res) -> {

            int bookId = Integer.valueOf(req.params(":id"));
            Book book = DBHelper.findById(bookId, Book.class);


            DBHelper.delete(book);

            res.redirect("/books");
            return null;

        }, new VelocityTemplateEngine());


    }
}
