package MonashBook.entity;

import MonashBook.entity.Book;
import MonashBook.entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-05-02T12:59:10")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Long> id;
    public static volatile SingularAttribute<Comment, Customer> customerComment;
    public static volatile SingularAttribute<Comment, String> comment;
    public static volatile SingularAttribute<Comment, Book> commentBook;

}