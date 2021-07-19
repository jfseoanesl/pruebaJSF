package beans.validator;

import beans.modelo.DniBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dniValidator")
public class DniValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        DniBean dni = (DniBean)t;
        if(this.isNotNumber(dni.getNumero())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: los primeros 8 valores del Dni deben ser numeros","Error: los primeros 8 valores del Dni deben ser numeros");
            throw new ValidatorException(msg);
        }
        else if(!Character.isLetter(dni.getLetra())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: El ultimo  caracter del Dni debe ser Letra","Error: El ultimo  caracter del Dni debe ser Letra");
            throw new ValidatorException(msg);
        }
        
       
    }
    
    public boolean isNotNumber(String value){
        for(char n: value.toCharArray()){
            if(!Character.isDigit(n))
                return true;
        }
        return false;
    }
    
}
