package MonashBook.entity;

import MonashBook.entity.Book;
import MonashBook.entity.Loan;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-05-02T12:59:10")
@StaticMetamodel(BookCopy.class)
public class BookCopy_ { 

    public static volatile SingularAttribute<BookCopy, Long> id;
    public static volatile ListAttribute<BookCopy, Loan> bookLent;
    public static volatile SingularAttribute<BookCopy, Book> bookCopy;
    public static volatile SingularAttribute<BookCopy, String> availability;

}