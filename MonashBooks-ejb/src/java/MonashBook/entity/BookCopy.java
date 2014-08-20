/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stephen
 */
@Entity
public class BookCopy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String availability;
    
    //mapping relationship between loan and book, a book can be loan many times
    @ManyToOne
    @JoinColumn(name="BOOK_ID")
    private Book bookCopy;
    
    //mapping the relationship between book and loan, a book can be lend many times
    @OneToMany(mappedBy = "lentBookCopy")
    private List<Loan> bookLent = new ArrayList<Loan>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Book getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(Book bookCopy) {
        this.bookCopy = bookCopy;
    }

    public List<Loan> getBookLent() {
        return bookLent;
    }

    public void setBookLent(List<Loan> bookLent) {
        this.bookLent = bookLent;
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
        if (!(object instanceof BookCopy)) {
            return false;
        }
        BookCopy other = (BookCopy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonashBook.entity.BookCopy[ id=" + id + " ]";
    }
    
}
