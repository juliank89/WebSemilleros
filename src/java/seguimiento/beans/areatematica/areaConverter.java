/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.areatematica;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Areatematica;


@FacesConverter(value = "areaConverter", forClass = Areatematica.class)
public class areaConverter implements Converter{

    @EJB
    private areaTematicaFacade areaTematicaBean;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) throws ConverterException  {
        if (string != null && string.trim().length() > 0) {
            return areaTematicaBean.find(Integer.parseInt(string));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) throws ConverterException  {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return String.valueOf(((Areatematica)o).getIdarea());
        }
    }
    
}
