/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.semillero;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import seguimiento.model.Semilleros;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EditarSemillero {

    private List<Semilleros> listaSemilleros;
    
    @EJB
    private semilleroFacade semilleroBean;
    
    public EditarSemillero() {
    }
    
    @PostConstruct
    public void cargar(){
        setListaSemilleros(semilleroBean.findAll());
    }

    /**
     * @return the listaSemilleros
     */
    public List<Semilleros> getListaSemilleros() {
        return listaSemilleros;
    }

    /**
     * @param listaSemilleros the listaSemilleros to set
     */
    public void setListaSemilleros(List<Semilleros> listaSemilleros) {
        this.listaSemilleros = listaSemilleros;
    }
    
     public void onRowEdit(RowEditEvent event) {
        FacesMessage message;
        
        Semilleros semilleroEditar = semilleroBean.find(((Semilleros)(event.getObject())).getIdsemilleros());
        semilleroEditar.setNombresemillero(((Semilleros)(event.getObject())).getNombresemillero());
        semilleroEditar.setFechaacta(((Semilleros)(event.getObject())).getFechaacta());
        
                
        try {
            semilleroBean.editar(semilleroEditar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }finally{
            cargar();
        }
    }
    public void onRowCancel(RowEditEvent event) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición Cancelada",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
