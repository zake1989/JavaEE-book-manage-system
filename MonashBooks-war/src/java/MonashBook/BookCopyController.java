/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import MonashBook.ejb.EntityManageBean;
import MonashBook.entity.Book;
import MonashBook.entity.BookCopy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author stephen
 */
@Named(value = "bookCopyController")
@SessionScoped
public class BookCopyController implements Serializable{

    @EJB
    EntityManageBean emb;
    private BookCopy bookcopy;
    private Book book;
    private int numberOfCopys;
    private Long bookid;
    
    /**
     * Creates a new instance of BookCopyController
     */
    public BookCopyController() {
        book = new Book();
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public List<BookCopy> getListCopy(Book book) {
        List<BookCopy> copylist = book.getBookCopyList();
        return copylist;
    }
    
    public int getNumberOfCopys() {
        return numberOfCopys;
    }

    public void setNumberOfCopys(int numberOfCopys) {
        this.numberOfCopys = numberOfCopys;
    }

    public BookCopy getBookcopy() {
        return bookcopy;
    }

    public void readBookcopy(BookCopy bc) {
        this.bookcopy = bc;
    }
    
    public void readBook(Book b) {
        this.book = b;
    }

    public void setupCreate() {
        bookcopy = new BookCopy();
    }

    public String create(Book b) {
        int i = numberOfCopys;
        for (Book bo : emb.getBooks()) {
            if (bo.getId() == b.getId()) {
                book = bo;
            }
        }
        for (int j = 0; j < i; j++) {
            bookcopy = new BookCopy();
            bookcopy.setAvailability("available");
            bookcopy.setBookCopy(book);
            book.getBookCopyList().add(bookcopy);
            emb.createBookCopy(bookcopy);
        }
        return "index";
    }

    public String changeAvailability(Long id) {
        for (BookCopy bc : emb.getBookCopys()) {
            if (bc.getId() == id) {
                bookcopy = bc;
            }
        }
        if (bookcopy.getAvailability().equals("available")) {
            bookcopy.setAvailability("not Available");
        } else  {
            bookcopy.setAvailability("available");
        }
        emb.updateBookCopy(bookcopy);
        return "bookDetail";
    }
    
    public String update() {
        emb.updateBookCopy(bookcopy);
        return "index";
    }

    public List<BookCopy> getBookCopys() {
        return emb.getBookCopys();
    }
    
    public List<BookCopy> getBookCopysForOneBook(Long id) {
        setBookid(id);
        List<BookCopy> bookCopies = new ArrayList<BookCopy>();
        bookCopies.clear();
        for (BookCopy bc : emb.getBookCopys()) {
            if (bc.getBookCopy().getId() == bookid) {
                bookCopies.add(bc);
            }
        }
        return bookCopies;
    }
}
