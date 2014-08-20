package MonashBook.entity;

import MonashBook.entity.BookCopy;
import MonashBook.entity.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-05-02T12:59:10")
@StaticMetamodel(Loan.class)
public class Loan_ { 

    public static volatile SingularAttribute<Loan, Long> id;
    public static volatile SingularAttribute<Loan, Date> expectReturnDate;
    public static volatile SingularAttribute<Loan, BookCopy> lentBookCopy;
    public static volatile SingularAttribute<Loan, Date> loanDate;
    public static volatile SingularAttribute<Loan, Date> returnDate;
    public static volatile SingularAttribute<Loan, Customer> bookForUser;

}