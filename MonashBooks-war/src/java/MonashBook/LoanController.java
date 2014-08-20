/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import Helper.Converter;
import MonashBook.ejb.EntityManageBean;
import MonashBook.entity.BookCopy;
import MonashBook.entity.Customer;
import MonashBook.entity.Loan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author stephen
 */
@Named(value = "loanController")
@Dependent
public class LoanController {
    
    @EJB
    EntityManageBean emb;
    private Loan loan;
    private Customer cust;
    private BookCopy book;
    private Long bookCopyID;
    private String name;
    private int days;

    /**
     * Creates a new instance of LoanController
     */
    public LoanController() {
        loan = new Loan();
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Long getBookCopyID() {
        return bookCopyID;
    }

    public void setBookCopyID(Long bookCopyID) {
        this.bookCopyID = bookCopyID;
    }

    public String getName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        name = facesContext.getExternalContext().getRemoteUser();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String setupCreate() {
        loan = new Loan();
        return "loanbook";
    }
    
    public String delete(Loan l) {
        emb.deleteLoan(l);
        return "index";
    }
    
    public String create(Long id) {
        setBookCopyID(id);
        for (Customer c: emb.getCustomers()) {
            if (c.getUsername().equals(getName())) {
                cust = c;
            }
        }
        for (BookCopy b: emb.getBookCopys()) {
            if (b.getId() == bookCopyID) {
                book = b;
            }
        }
        if (book.getAvailability().equals("not Available")) {
            return "booknotavaliable";
        }else{
            days = 7;
            loan.setLoanDate(Converter.getCurrentDate());
            loan.setExpectReturnDate(Converter.getExpectReturnDate(days));
            loan.setReturnDate(null);
            loan.setLentBookCopy(book);
            loan.setBookForUser(cust);
            book.getBookLent().add(loan);
            book.setAvailability("not Available");
            cust.getUserLentBook().add(loan);
            emb.createLoan(loan);
            emb.updateBookCopy(book);
            return "loanbook";
        }
    }
    
    public String getFormatDate(Date d) {
        return Converter.convertDate(d);
    }
    
    public String returnBook(Long loanid) {
        for (Loan l : emb.getLoans()) {
            if (l.getId() == loanid) {
                loan = l;
            }
        }
        for (BookCopy bc : emb.getBookCopys()) {
            if (bc.getId() == loan.getLentBookCopy().getId()) {
                book = bc;
            }
        }
        book.setAvailability("available");
        loan.setReturnDate(Converter.getCurrentDate());
        emb.updateBookCopy(book);
        emb.updateLoan(loan);
        
        return "returnbook";
    }
    
    public List<Loan> getLoans() {
        return emb.getLoans();
    }
    
    public List<Loan> getLoansForCustomer() {
        List<Loan> loans = new ArrayList<Loan>();
        for (Loan l : emb.getLoans()) {
            if (l.getBookForUser().getUsername().equals(getName())) {
                loans.add(l);
            }
        }
        return loans;
    }

    public List<Loan> getFinishLoansForCustomer() {
        List<Loan> finishedLoans = new ArrayList<Loan>();
        for (Loan l : emb.getLoans()) {
            if (l.getBookForUser().getUsername().equals(getName()) && l.getReturnDate() != null) {
                    finishedLoans.add(l);
            }
        }
        return finishedLoans;
    }
    
    public List<Loan> getProcessingLoansForCustomer() {
        List<Loan> processingLoans = new ArrayList<Loan>();
        for (Loan l : emb.getLoans()) {
            if (l.getBookForUser().getUsername().equals(getName()) && l.getReturnDate() == null) {
                    processingLoans.add(l);
            }
        }
        return processingLoans;
    }
}
