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
import seguimiento.model.Centroinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class BorrarCentroBean {

    @EJB
    private centroInvestigacionFacade centroBean;
    private List<Centroinvestigacion> listaCentrosInvestigacion;
    
    public BorrarCentroBean() {
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
        setListaCentrosInvestigacion(null);
        setListaCentrosInvestigacion(centroBean.findAll());
    }
    
    public void eliminar(int idCentro){
        FacesMessage message;
        Centroinvestigacion centroEliminar= centroBean.find(idCentro);
        try {
            centroBean.eliminar(centroEliminar); //.removeCentro(idCentro);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Centro de Investigación se ha Eliminado Exitosamente",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }finally{
            cargar();
        }
    }
}
