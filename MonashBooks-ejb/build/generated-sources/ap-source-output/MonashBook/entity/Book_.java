package MonashBook.entity;

import MonashBook.entity.BookCopy;
import MonashBook.entity.Comment;
import MonashBook.entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-05-02T12:59:10")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, String> imageUrl;
    public static volatile SingularAttribute<Book, String> ISBN;
    public static volatile ListAttribute<Book, BookCopy> bookCopyList;
    public static volatile SingularAttribute<Book, String> publishdate;
    public static volatile ListAttribute<Book, Comment> booksComment;
    public static volatile SingularAttribute<Book, String> publisher;
    public static volatile SingularAttribute<Book, String> version;
    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, String> category;
    public static volatile SingularAttribute<Book, String> description;
    public static volatile ListAttribute<Book, Customer> customerList;

}