/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stephen
 */
@Entity
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String comment;
    
    //mapping relationship between comment and book, a book can be comment many times
    @ManyToOne
    @JoinColumn(name="BOOK_ID")
    private Book commentBook;
    
    //mapping relationship between comment and user, a user can add comment many times
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private Customer customerComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getCommentBook() {
        return commentBook;
    }

    public void setCommentBook(Book commentBook) {
        this.commentBook = commentBook;
    }

    public Customer getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(Customer customerComment) {
        this.customerComment = customerComment;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonashBook.entity.Comment[ id=" + id + " ]";
    }
    
}
