/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.tipoproducto;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Tipoproducto;

@FacesConverter(value = "tipoProductoConverter", forClass = Tipoproducto.class)
public class tipoProductoConverter implements Converter{
    
    @EJB
    private tipoProductoFacade tipoProductoBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            return tipoProductoBean.find(Integer.parseInt(value));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Tipoproducto)value).getIdtipo());
        }
    }
}