
package beans.controllers;

import beans.backing.LoginBackingBean;
import beans.modelo.ListUsuarioBean;
import beans.modelo.UserBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class AccessController implements Serializable {
    
    @Inject
    private LoginBackingBean loginBB;
   
    private boolean loginError;
    private String errorMsg;
    
    @Inject
    private UserBean user;
    
    @Inject
    private ListUsuarioBean usuarios;
           
    /**
     * @return the loginBB
     */
    public LoginBackingBean getLoginBB() {
        return loginBB;
    }

    /**
     * @param loginBB the loginBB to set
     */
    public void setLoginBB(LoginBackingBean loginBB) {
        this.loginBB = loginBB;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
    /**
     * @return the loginError
     */
    public boolean isLoginError() {
        return loginError;
    }

    /**
     * @param loginError the loginError to set
     */
    public void setLoginError(boolean loginError) {
        this.loginError = loginError;
    }
    
    public String doRegister(){
        return "user-register";
    }
    
    public String doLogin(){
        /*if(this.getLoginBB().getLogin().equals("Admin")){
            if(this.getLoginBB().getPassword().equals("Admin")){
                this.loginError=false;
                this.errorMsg = "Datos de acceso correctos";
                
                this.getUser().setName(this.getLoginBB().getLogin());
                
                return "login-success";
            }
            else{
                this.errorMsg = "Error de Acceso: El password es incorrecto";
            }
        }*/
        if(this.getUsuarios().verificarUsuario(this.getLoginBB().getLogin(), this.getLoginBB().getPassword())){
            this.getUser().setName(this.getLoginBB().getLogin());
            return "login-success";
        }
        else{
            this.errorMsg = "Error de Acceso: El usuario es incorrecto";
        }
        this.loginError=true;
        return "login-error";
    }
    
    public String doLogout(){
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sesion.invalidate();
        return "logout";
        
    }

    /**
     * @return the user
     */
    public UserBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserBean user) {
        this.user = user;
    }

    /**
     * @return the usuarios
     */
    public ListUsuarioBean getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(ListUsuarioBean usuarios) {
        this.usuarios = usuarios;
    }

}
