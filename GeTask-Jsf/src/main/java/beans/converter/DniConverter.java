package beans.converter;

import beans.modelo.DniBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("dniConverter")
public class DniConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valueStr) throws ConverterException {

        if (valueStr.length() != 9) {
            throw new ConverterException(new FacesMessage("El dni debe poseer 9 caracteres"));
        }

        String numeros = valueStr.substring(0, 8);
        char letra = valueStr.charAt(8);
        DniBean dni = new DniBean();
        dni.setNumero(numeros);
        dni.setLetra(letra);
        return dni;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        DniBean dni = (DniBean) (value);
        return dni.getNumero() + dni.getLetra();
    }

}
