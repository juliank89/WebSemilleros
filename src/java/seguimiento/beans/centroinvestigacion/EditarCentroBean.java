/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.centroinvestigacion;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import seguimiento.model.Centroinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EditarCentroBean {

    @EJB
    private centroInvestigacionFacade centroBean;
    private List<Centroinvestigacion> listaCentrosInvestigacion;
    
    public EditarCentroBean() {
        //cargar();
    }
    
    /**
     * @return the listaCentrosInvestigacion
     */
    public List<Centroinvestigacion> getListaCentrosInvestigacion() {
        return listaCentrosInvestigacion;
    }

    /**
     * @param listaCentrosInvestigacion the listaCentrosInvestigacion to set
     */
    public void setListaCentrosInvestigacion(List<Centroinvestigacion> listaCentrosInvestigacion) {
        this.listaCentrosInvestigacion = listaCentrosInvestigacion;
    }
    
    @PostConstruct
    public void cargar(){
        setListaCentrosInvestigacion(centroBean.findAll());
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage message;
        Centroinvestigacion centroEditar= new Centroinvestigacion(((Centroinvestigacion) (event.getObject())).getIdcentro());
        centroEditar.setNombrecentro(((Centroinvestigacion) (event.getObject())).getNombrecentro()); 
        centroEditar.setDescripcion(((Centroinvestigacion) (event.getObject())).getDescripcion());
        
        try {
            centroBean.editar(centroEditar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición Cancelada",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
