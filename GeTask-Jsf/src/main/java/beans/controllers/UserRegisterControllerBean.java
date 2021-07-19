
package beans.controllers;

import beans.backing.RegisterBackingBean;
import beans.modelo.ListUsuarioBean;
import beans.modelo.UserBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@SessionScoped
public class UserRegisterControllerBean implements Serializable {
    @Inject
    private RegisterBackingBean registerBB;
    
    @Inject
    private UserBean user;
    
    @Inject
    private ListUsuarioBean usuarios;
    
    
    
    public void validateEqualsPassword(final ComponentSystemEvent event)throws AbortProcessingException{
        UIComponent source = event.getComponent();
        UIInput inputPasswordOne = (UIInput)source.findComponent("inputPasswordOne");
        UIInput inputPasswordTwo = (UIInput)source.findComponent("inputPasswordTwo");
        
        String passw1 = (String)inputPasswordOne.getValue();
        String passw2 = (String)inputPasswordTwo.getValue();
        if(!passw1.equals(passw2)){
            /*FacesMessage message = es.ua.jtech.util.Messages.getMessage(
                                    "es.ua.jtech.messages",
                                    "invalidDate",
                                    null
                                    );
             */
            FacesMessage msg = new FacesMessage();
            msg.setDetail("Los password deber ser iguales");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary("No hay coincidencia en los password");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(source.getClientId(), msg);
            context.renderResponse();
        }
    }
    
    public void validateLoginExist(final ComponentSystemEvent event){
        UIInput inputLogin =(UIInput) event.getComponent();
        String login = (String)inputLogin.getValue();
        if(this.usuarios.validateLoginExist(login)){
            FacesMessage msg = new FacesMessage();
            msg.setDetail("El login ya se encuentra registrado para otro usuario");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary("Login ya se encuentra registrado");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(inputLogin.getClientId(), msg);
            context.renderResponse();
        }
    }
    
    public String doRegister(){
        this.usuarios.addUsuario(this.registerBB.getLogin(), this.registerBB.getPasswordOne());
        this.getUser().setName(this.registerBB.getLogin());
        return "login-success";
        
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

    /**
     * @return the registerBB
     */
    public RegisterBackingBean getRegisterBB() {
        return registerBB;
    }

    /**
     * @param registerBB the registerBB to set
     */
    public void setRegisterBB(RegisterBackingBean registerBB) {
        this.registerBB = registerBB;
    }
    
}
