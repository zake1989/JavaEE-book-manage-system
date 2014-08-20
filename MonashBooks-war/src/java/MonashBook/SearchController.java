/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import MonashBook.ejb.EntityManageBean;
import MonashBook.entity.Book;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author stephen
 */
@Named(value = "searchController")
@SessionScoped
public class SearchController implements Serializable {
    
    @EJB
    EntityManageBean emb;
    private String keyWords;
    private List<Book> resultBookList = new ArrayList<Book>();
    /**
     * Creates a new instance of SearchController
     */
    public SearchController() {
    }

    public List<Book> getResultBookList() {
        return resultBookList;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    
    public String searchBook() {
        resultBookList.clear();
        for (Book b : emb.getBooks()) {
            if (b.getAuthor().toLowerCase().contains(keyWords.toLowerCase())) {
                resultBookList.add(b);
            } else if (b.getTitle().toLowerCase().contains(keyWords.toLowerCase())) {
                resultBookList.add(b);
            } else if (b.getPublisher().toLowerCase().contains(keyWords.toLowerCase())) {
                resultBookList.add(b);
            } else if (b.getCategory().toLowerCase().contains(keyWords.toLowerCase())) {
                resultBookList.add(b);
            }
        }
        return "SearchResult";
    }
}
