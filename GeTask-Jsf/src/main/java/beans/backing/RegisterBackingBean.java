package beans.backing;

import beans.modelo.DniBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class RegisterBackingBean implements Serializable {
    
    @Inject
    private DniBean dni;
    
    @NotNull
    @Size(min = 4,max = 12)
    private String login="";
   
    @NotNull
    @Size(min = 6,max = 12)
    private String passwordOne="";
    
    @NotNull
    @Size(min = 6,max = 12)
    private String passwordTwo="";

    public RegisterBackingBean() {
    }

    /**
     * @return the dni
     */
    public DniBean getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(DniBean dni) {
        this.dni = dni;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the passwordOne
     */
    public String getPasswordOne() {
        return passwordOne;
    }

    /**
     * @param passwordOne the passwordOne to set
     */
    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    /**
     * @return the passwordTwo
     */
    public String getPasswordTwo() {
        return passwordTwo;
    }

    /**
     * @param passwordTwo the passwordTwo to set
     */
    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }
    
    
    
}
