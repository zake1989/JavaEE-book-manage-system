/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import MonashBook.ejb.EntityManageBean;
import MonashBook.entity.Book;
import MonashBook.entity.BookCopy;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author stephen
 */
@Named(value = "bookController")
@SessionScoped
public class BookController implements Serializable {

    @EJB
    EntityManageBean emb;
    private Book book;
    private ArrayList<String> categoryList;
    /**
     * Creates a new instance of BookController
     */
    public BookController() {
        book = new Book();
        categoryList = new ArrayList<String>();
        categoryList.add("Business");
        categoryList.add("Technical");
        categoryList.add("Fiction");
        categoryList.add("Nonfiction");
        categoryList.add("Special Interest");
        categoryList.add("Young Readers");
        categoryList.add("Travel");
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }
    
    public List<BookCopy> getBookCopysFromBook(Book bo) {
        this.book = bo;
        List<BookCopy> bookCopy;
        bookCopy = new ArrayList<BookCopy>();
        for (Book b : emb.getBooks()) {
            if (b.getISBN().equals(book.getISBN())) {
                bookCopy = b.getBookCopyList();
            }
        }
        return bookCopy;
    }
    
    public Book getBook() {
        return book;
    }

    public String readBook(Book b) {
        this.book = b;
        return "bookDetail";
    }

    public String viewBook(Book b) {
        this.book = b;
        return "loanbook";
    }
    
    public String setupCreate() {
        book = new Book();
        return "manageBook";
    }

    public String create() {
        book.setImageUrl("../resources/image/02.jpg");
        emb.createBook(book);
        return "index";
    }

    public String update() {
        emb.updateBook(book);
        return "index";
    }

    public String delete(Book b) {
        emb.deleteBook(b);
        return "index";
    }
    
    public String deleteBookCopy(Book b, BookCopy bc) {
        //b.getBookCopyList()
        emb.deleteBookCopy(bc);
        return "bookDetail";
    }

    public List<Book> getBooks() {
        return emb.getBooks();
    }
}
