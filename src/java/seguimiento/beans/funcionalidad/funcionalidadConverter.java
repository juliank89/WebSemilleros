/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.funcionalidad;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Funcionalidad;

@FacesConverter(value = "funcionalidadConverter", forClass = Funcionalidad.class)
public class funcionalidadConverter implements Converter{

    @EJB
    private funcionalidadFacade funcionalidadBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException{
        if (value != null && value.trim().length() > 0) {
            return funcionalidadBean.find(Integer.parseInt(value));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Funcionalidad)value).getIdfuncionalidad());
        }
    }
    
}
