/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.categoria;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import seguimiento.model.Categoria;

/**
 *
 * @author root
 */
@FacesConverter(value = "categoriaConverter", forClass = Categoria.class)
public class categoriaConverter implements Converter{

    @EJB
    private categoriaFacade categoriaBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            return categoriaBean.find(Integer.parseInt(value));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
             
            return String.valueOf(((Categoria)value).getIdcategoria());
        }
    }
    
}
