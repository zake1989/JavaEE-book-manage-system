/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook.ejb;

import MonashBook.entity.Book;
import MonashBook.entity.BookCopy;
import MonashBook.entity.Comment;
import MonashBook.entity.Customer;
import MonashBook.entity.Loan;
import MonashBook.entity.UserGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author stephen
 */
@Stateless
@LocalBean
public class EntityManageBean {
    @PersistenceContext(unitName = "MonashBooks-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void createCustomer(Customer c) {
        em.persist(c);
    }
    
    public void createUserGroup(UserGroup u) {
        em.persist(u);
    }
    
    public void createBook(Book b) {
        em.persist(b);
    }
    
    public void createBookCopy(BookCopy bc) {
        em.persist(bc);
    }
    
    public void createLoan(Loan l) {
        em.persist(l);
    }
    
    public void createComment(Comment ct) {
        em.persist(ct);
    }

    public void updateCustomer(Customer c) {
        em.merge(c);
    }
    
    public void updateUserGroup(UserGroup u) {
        em.merge(u);
    }
    
    public void updateBook(Book b) {
        em.merge(b);
    }
    
    public void updateBookCopy(BookCopy bc) {
        em.merge(bc);
    }
    
    public void updateLoan(Loan l) {
        em.merge(l);
    }
    
    public void updateComment(Comment ct) {
        em.merge(ct);
    }
    
    public void deleteCustomer(Customer c) {
        em.remove(em.merge(c));
    }
    
    public void deleteUserGroup(UserGroup u) {
        em.remove(em.merge(u));
    }
    
    public void deleteBook(Book b) {
        em.remove(em.merge(b));
    }
    
    public void deleteLoan(Loan l) {
        em.remove(em.merge(l));
    }
    
    public void deleteBookCopy(BookCopy bc) {
        em.remove(em.merge(bc));
    }
    
    public void deleteComment(Comment ct) {
        em.remove(em.merge(ct));
    }
    
    public List<Customer> getCustomers() {
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }
    
    public List<UserGroup> getUserGroups() {
        TypedQuery<UserGroup> query = em.createQuery(
                "SELECT u FROM UserGroup u", UserGroup.class);
        return query.getResultList();
    }
    
    public List<Book> getBooks() {
        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b", Book.class);
        return query.getResultList();       
    }
    
    public List<BookCopy> getBookCopys() {
        TypedQuery<BookCopy> query = em.createQuery(
                "SELECT bc FROM BookCopy bc", BookCopy.class);
        return query.getResultList();       
    }
    
    public List<Loan> getLoans() {
        TypedQuery<Loan> query = em.createQuery(
                "SELECT l FROM Loan l", Loan.class);
        return query.getResultList();
    }
    
    public List<Comment> getComments() {
        TypedQuery<Comment> query = em.createQuery(
                "SELECT ct FROM Comment ct",Comment.class);
        return query.getResultList();
    }
}
