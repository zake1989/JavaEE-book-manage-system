/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import Helper.Converter;
import MonashBook.ejb.EntityManageBean;
import MonashBook.entity.Book;
import MonashBook.entity.Customer;
import MonashBook.entity.UserGroup;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author stephen
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {
    
    @EJB
    EntityManageBean emb;
    private Customer customer;
    private Book book;
    private String password;
    private UserGroup userGroup;
    private ArrayList<String> groups;
    private String currentUsername;
    private List<Book> markedBooks;
    private List<Book> normalBooks;
    
    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
        groups = new ArrayList<String>();
        userGroup = new UserGroup();
        customer = new Customer();
        groups.add("admin");
        groups.add("user");

    }

    public List<Book> getMarkedBooks() {
        return markedBooks;
    }

    public void setMarkedBooks(List<Book> markedBooks) {
        this.markedBooks = markedBooks;
    }

    public List<Book> getNormalBooks() {
        return normalBooks;
    }

    public void setNormalBooks(List<Book> normalBooks) {
        this.normalBooks = normalBooks;
    }

    public String getCurrentUsername() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        currentUsername = facesContext.getExternalContext().getRemoteUser();
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public String readCustomer(Customer customer) {
        this.customer = customer;
        return "Register";
    }
    
    public String setupCreate() {
        customer = new Customer();
        return "Register";
    }
    
    public String create() {
        customer.setPassword(Converter.convertString(password));
        emb.createCustomer(customer);
        emb.createUserGroup(userGroup);
        return "index";
    }
    
    public String update() {
        customer.setPassword(Converter.convertString(password));
        emb.updateCustomer(customer);
        return "index";
    }
    
    public String delete(Customer c) {
        emb.deleteCustomer(c);
        return "index";
    }
    
    public List<Customer> getCustomers() {
        return emb.getCustomers();
    }
    
    public void findCustomer() {
        customer = new Customer();
        for (Customer c : emb.getCustomers()) {
            if (c.getUsername().equals(currentUsername)) {
                customer = c;
            }
        }
    }
    
    public void findBook(Book b) {
        for (Book bo : emb.getBooks()) {
            if (bo.getId() == b.getId()) {
                book = bo;
            }
        }
    }
    
    public String markBook(Book b) {
        findBook(b);
        findCustomer();
        book.getCustomerList().add(customer);
        customer.getMarkedBook().add(book);
        emb.updateCustomer(customer);
        divideBooks();
        return "managePreference";
    }
    
    public String unmarkBook(Book b) {
        findBook(b);
        findCustomer();
        book.getCustomerList().remove(customer);
        customer.getMarkedBook().remove(book);
        emb.updateCustomer(customer);
        divideBooks();
        return "managePreference";
    }
    
    public String divideBooks() {
        markedBooks = new ArrayList<Book>();
        normalBooks = new ArrayList<Book>();
        findCustomer();
        for (Book b : emb.getBooks()) {
            if (customer.getMarkedBook().contains(b)) {
                markedBooks.add(b);
            } else {
                normalBooks.add(b);
            }
        }
        return "managePreference";
    }
}
