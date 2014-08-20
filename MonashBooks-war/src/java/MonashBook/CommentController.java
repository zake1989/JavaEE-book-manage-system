/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import MonashBook.ejb.EntityManageBean;
import MonashBook.entity.Book;
import MonashBook.entity.Comment;
import MonashBook.entity.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author stephen
 */
@Named(value = "commentController")
@SessionScoped
public class CommentController implements Serializable {

    @EJB
    EntityManageBean emb;
    private Comment comment;
    private Customer cust;
    private Book book;
    private String name;
    private String commentContent;
    /**
     * Creates a new instance of CommentController
     */
    public CommentController() {
        comment = new Comment();
    }

    public Book getBook() {
        return book;
    }

    public String readBook(Book book) {
        this.book = book;
        return "addComment";
    }
    
    public String readBookForadmin(Book book) {
        this.book = book;
        return "viewcomment";
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        name = facesContext.getExternalContext().getRemoteUser();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String create() {
        cust = new Customer();
        for (Customer c : emb.getCustomers()) {
            if (c.getUsername().equals(getName())) {
                cust = c;
            }
        }
        comment.setComment(commentContent);
        comment.setCommentBook(book);
        comment.setCustomerComment(cust);
        book.getBooksComment().add(comment);
        cust.getCommentsAddByCustomer().add(comment);
        emb.createComment(comment);
        return "addComment";
    }
}
