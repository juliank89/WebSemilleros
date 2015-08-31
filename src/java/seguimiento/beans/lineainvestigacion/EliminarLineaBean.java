/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.lineainvestigacion;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import seguimiento.model.Lineainvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EliminarLineaBean {

    @EJB
    private LineaInvestigacionFacade lineaBean;
    
    private List<Lineainvestigacion> listaLineasInvestigacion;
    
    public EliminarLineaBean() {
        //cargar();
    }
    
    /**
     * @return the listaLineasInvestigacion
     */
    public List<Lineainvestigacion> getListaLineasInvestigacion() {
        return listaLineasInvestigacion;
    }

    /**
     * @param listaLineasInvestigacion the listaLineasInvestigacion to set
     */
    public void setListaLineasInvestigacion(List<Lineainvestigacion> listaLineasInvestigacion) {
        this.listaLineasInvestigacion = listaLineasInvestigacion;
    }
    
    @PostConstruct
    public void cargar(){
        setListaLineasInvestigacion(lineaBean.findAll());
    }
    
    public void eliminar(int idLinea){
        FacesMessage message;
        try {
            lineaBean.eliminar(lineaBean.find(idLinea));
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }finally{
            cargar();
        }
    }
}
