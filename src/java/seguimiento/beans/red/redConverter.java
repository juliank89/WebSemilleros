/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.red;

import java.util.List;
import java.util.Vector;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Red;

/**
 *
 * @author root
 */
@FacesConverter(value = "redConverter", forClass = Red.class)
public class redConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        List<Red> redes = (List<Red>) context.getApplication().evaluateExpressionGet(context, "#{crearSemillero.listaRedes}", Vector.class);

        for (Red rede : redes) {
            if (rede.getIdred()==(Integer.parseInt(value))) {
                return rede;
            }
        }

        return null;
        
        
//        if (value != null && value.trim().length() > 0) {
//            return new redFacade().find(Integer.parseInt(value));
//        } else {
//            return null;
//        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Red)value).getIdred());
        }
    }
    
}
