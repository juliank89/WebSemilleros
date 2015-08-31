/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.grupoinvestigacion;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Grupoinvestigacion;

@FacesConverter(value = "grupoConverter", forClass = Grupoinvestigacion.class)
public class grupoConverter implements Converter {

    @EJB
    private grupoInvestigacionFacade grupoBean;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) throws ConverterException {
        if (string != null && string.trim().length() > 0) {
            return (Grupoinvestigacion)grupoBean.find(Integer.parseInt(string));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) throws ConverterException {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return String.valueOf(((Grupoinvestigacion)o).getIdgrupo());
        }
    }
}
