/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.red;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import seguimiento.beans.contacto.contactoFacade;
import seguimiento.model.Contacto;
import seguimiento.model.Red;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EliminarRedBean {

    @EJB
    private redFacade redBean;
    @EJB
    private contactoFacade contactoBean;
    
    private List<Red> listaRedesInvestigacion;
    
    
    public EliminarRedBean() {
    }
    
    @PostConstruct
    public void cargar(){
        setListaRedesInvestigacion(redBean.findAll());
    }
    
    /**
     * @return the listaRedesInvestigacion
     */
    public List<Red> getListaRedesInvestigacion() {
        return listaRedesInvestigacion;
    }

    /**
     * @param listaRedesInvestigacion the listaRedesInvestigacion to set
     */
    public void setListaRedesInvestigacion(List<Red> listaRedesInvestigacion) {
        this.listaRedesInvestigacion = listaRedesInvestigacion;
    }
    
    public void eliminar(int idRed){
        FacesMessage message;
        Red redAux=redBean.find(idRed);
        
        try {
            for (Contacto listaContacto : redAux.getContactoCollection()) {
                contactoBean.eliminar(listaContacto);
            }
            redBean.eliminar(redAux);
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
