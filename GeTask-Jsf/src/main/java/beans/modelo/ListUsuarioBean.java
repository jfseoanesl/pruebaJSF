
package beans.modelo;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ListUsuarioBean {
    
    private Map<String, String> usuarios;

    public ListUsuarioBean() {
        this.usuarios = new HashMap();
        this.usuarios.put("Admin", "Admin");
    }

    /**
     * @return the usuarios
     */
    public Map<String, String> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Map<String, String> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void addUsuario(String login, String password){
        this.usuarios.put(login, password);
    }
    
    public boolean verificarUsuario(String login, String password){
        
        for(Map.Entry user : this.usuarios.entrySet()){
            if(((String)(user.getKey())).equals(login) && ((String)(user.getValue())).equals(password) ){
                return true;
            }
        }
        return false;
    }
    
    public boolean validateLoginExist(String login){
        for(Map.Entry user : this.usuarios.entrySet()){
            if(((String)(user.getKey())).equals(login)){
                return true;
            }
        }
        return false;
    }
    
    
}
