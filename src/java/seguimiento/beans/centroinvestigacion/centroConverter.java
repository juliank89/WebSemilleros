/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.centroinvestigacion;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Centroinvestigacion;

@FacesConverter(value = "centroConverter", forClass = Centroinvestigacion.class)
public class centroConverter implements Converter{

    @EJB
    private centroInvestigacionFacade centroInvestigacionBean;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) throws ConverterException{
        
        if (string.trim().equals("")) {
            return null;
        } else {
            return centroInvestigacionBean.find(Integer.parseInt(string));
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) throws ConverterException{
         if (o == null || o.equals("")) {
            return "";
        } else {
            String aaa = String.valueOf(((Centroinvestigacion) o).getIdcentro());
            return String.valueOf(((Centroinvestigacion) o).getIdcentro());
        }
    }
    
    
    
}
