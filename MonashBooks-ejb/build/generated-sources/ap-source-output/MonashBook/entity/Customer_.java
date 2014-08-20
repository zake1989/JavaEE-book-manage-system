package MonashBook.entity;

import MonashBook.entity.Book;
import MonashBook.entity.Comment;
import MonashBook.entity.Loan;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-05-02T12:59:10")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile ListAttribute<Customer, Book> markedBook;
    public static volatile SingularAttribute<Customer, String> username;
    public static volatile SingularAttribute<Customer, String> phoneNumber;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile ListAttribute<Customer, Comment> commentsAddByCustomer;
    public static volatile ListAttribute<Customer, Loan> userLentBook;
    public static volatile SingularAttribute<Customer, String> password;

}