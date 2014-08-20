/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonashBook;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author stephen
 */
@Named(value = "indexController")
@SessionScoped
public class IndexController implements Serializable {

    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
    }

    public String logOut() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        httpSession.invalidate();
        
        return "/faces/index.xhtml";
    }
}
