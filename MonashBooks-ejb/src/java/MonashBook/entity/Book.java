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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stephen
 */
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String category;
    @NotNull
    private String publisher;
    @NotNull
    private String publishdate;
    @NotNull
    private String description;
    
    private String imageUrl;
    @NotNull
    private String ISBN;
    @NotNull
    private String version;
    
    //mapping the relationship between book and loan, a book can be lend many times
    @OneToMany(mappedBy = "bookCopy")
    private List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
    
    //mapping the book customer marked
    @ManyToMany(mappedBy = "markedBook") 
    private List<Customer> customerList = new ArrayList<Customer>();
    
        //mapping the relationship between book and comment, a book can be comment many times
    @OneToMany(mappedBy = "commentBook")
    private List<Comment> booksComment = new ArrayList<Comment>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<BookCopy> getBookCopyList() {
        return bookCopyList;
    }

    public void setBookCopyList(List<BookCopy> bookCopyList) {
        this.bookCopyList = bookCopyList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Comment> getBooksComment() {
        return booksComment;
    }

    public void setBooksComment(List<Comment> booksComment) {
        this.booksComment = booksComment;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonashBook.entity.Book[ id=" + id + " ]";
    }
}
