/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author stephen
 */
@Entity
public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE) 
    private Date loanDate;
    @Temporal(TemporalType.DATE)
    private Date expectReturnDate;
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    
    //mapping relationship between loan and book, a book can be loan many times
    @ManyToOne
    @JoinColumn(name="BOOKCOPY_ID")
    private BookCopy lentBookCopy;
    
    //mapping relationship between loan and book, a book can be loan many times
    @ManyToOne
    @JoinColumn(name="Customer_ID")
    private Customer bookForUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getExpectReturnDate() {
        return expectReturnDate;
    }

    public void setExpectReturnDate(Date expectReturnDate) {
        this.expectReturnDate = expectReturnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BookCopy getLentBookCopy() {
        return lentBookCopy;
    }

    public void setLentBookCopy(BookCopy lentBookCopy) {
        this.lentBookCopy = lentBookCopy;
    }

    public Customer getBookForUser() {
        return bookForUser;
    }

    public void setBookForUser(Customer bookForUser) {
        this.bookForUser = bookForUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonashBook.entity.Loan[ id=" + id + " ]";
    }
    
}
