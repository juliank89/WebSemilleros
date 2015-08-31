/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.rol;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Rol;

@FacesConverter(value = "rolConverter", forClass = Rol.class)
public class rolConverter implements Converter {

    @EJB
    private rolFacade rolBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        if (value != null && value.trim().length() > 0) {
            return rolBean.find(Integer.parseInt(value));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Rol)value).getIdrol());
        }
    }
    
}
