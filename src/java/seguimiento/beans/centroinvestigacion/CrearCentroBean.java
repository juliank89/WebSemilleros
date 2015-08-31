/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.centroinvestigacion;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;
import javax.faces.validator.ValidatorException;
import seguimiento.model.Centroinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class CrearCentroBean {

    private Centroinvestigacion centroInvestigacion;
    @EJB
    private centroInvestigacionFacade centroBean;

    public CrearCentroBean() {
    }

    /**
     * @return the centroInvestigacion
     */
    public Centroinvestigacion getCentroInvestigacion() {
        
        if(centroInvestigacion==null){
            centroInvestigacion = new Centroinvestigacion();
        }
        return centroInvestigacion;
    }

    /**
     * @param centroInvestigacion the centroInvestigacion to set
     */
    public void setCentroInvestigacion(Centroinvestigacion centroInvestigacion) {
        this.centroInvestigacion = centroInvestigacion;
    }
    
    /**
     * Evento de Boton para crear un centro de investigación
     * @param actionEvent 
     */
    public void CrearCentro(ActionListener actionEvent) {
        FacesMessage message;
        try {
            centroBean.crear(getCentroInvestigacion());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Centro de Investigación Ingresado correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (ValidatorException e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (javax.persistence.PersistenceException e) {
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error en el sistema", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
