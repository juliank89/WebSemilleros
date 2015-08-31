/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.grupoinvestigacion;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;
import seguimiento.beans.centroinvestigacion.centroInvestigacionFacade;
import seguimiento.model.Centroinvestigacion;
import seguimiento.model.Grupoinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class CrearGrupoBean {

    /**
     * Creates a new instance of CrearGrupoBean
     */
    public CrearGrupoBean() {
    }
    
    private Grupoinvestigacion grupoInvestigacion;
    private List<Centroinvestigacion> listaCentrosInvestigacion;

    @EJB
    private grupoInvestigacionFacade grupoBean;
    @EJB
    private centroInvestigacionFacade centroBean;

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
    
    /**
     * @return the grupoInvestigacion
     */
    public Grupoinvestigacion getGrupoInvestigacion() {
        if(grupoInvestigacion==null){
            grupoInvestigacion= new Grupoinvestigacion();
        }
        return grupoInvestigacion;
    }

    /**
     * @param grupoInvestigacion the grupoInvestigacion to set
     */
    public void setGrupoInvestigacion(Grupoinvestigacion grupoInvestigacion) {
        this.grupoInvestigacion = grupoInvestigacion;
    }
    
    @PostConstruct
    public void cargar(){
        setListaCentrosInvestigacion(centroBean.findAll());
    }
    
    public void CrearGrupo(ActionListener actionEvent) {
        
        FacesMessage message;
        try {
            grupoBean.crear(grupoInvestigacion);
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Investigación Ingresado correctamente",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
