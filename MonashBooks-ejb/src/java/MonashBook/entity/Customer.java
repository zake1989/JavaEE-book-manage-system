/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stephen
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @NotNull
    private String password;
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;
    
    //mapping relationship between user and book
    @OneToMany(mappedBy = "bookForUser")
    private List<Loan> userLentBook = new ArrayList<Loan>();
    
    //mapping many to many bookmark relationship
    @ManyToMany
    @JoinTable(name = "bookmark",
               joinColumns = @JoinColumn(name = "Customer_ID"),
               inverseJoinColumns = @JoinColumn(name = "Book_ID"))
    private List<Book> markedBook = new ArrayList<Book>();
    
    //mapping relationship between user and book
    @OneToMany(mappedBy = "customerComment")
    private List<Comment> commentsAddByCustomer = new ArrayList<Comment>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Loan> getUserLentBook() {
        return userLentBook;
    }

    public void setUserLentBook(List<Loan> userLentBook) {
        this.userLentBook = userLentBook;
    }

    public List<Book> getMarkedBook() {
        return markedBook;
    }

    public void setMarkedBook(List<Book> markedBook) {
        this.markedBook = markedBook;
    }

    public List<Comment> getCommentsAddByCustomer() {
        return commentsAddByCustomer;
    }

    public void setCommentsAddByCustomer(List<Comment> commentsAddByCustomer) {
        this.commentsAddByCustomer = commentsAddByCustomer;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonashBook.entity.Customer[ id=" + id + " ]";
    }
    
}
