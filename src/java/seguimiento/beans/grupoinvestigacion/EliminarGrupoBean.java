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
import seguimiento.model.Grupoinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EliminarGrupoBean {

    @EJB
    private grupoInvestigacionFacade grupoBean;
    private List<Grupoinvestigacion> listaGruposInvestigacion;
    
    public EliminarGrupoBean() {
    //cargar();
    }

    /**
     * @return the listaGruposInvestigacion
     */
    public List<Grupoinvestigacion> getListaGruposInvestigacion() {
        return listaGruposInvestigacion;
    }

    /**
     * @param listaGruposInvestigacion the listaGruposInvestigacion to set
     */
    public void setListaGruposInvestigacion(List<Grupoinvestigacion> listaGruposInvestigacion) {
        this.listaGruposInvestigacion = listaGruposInvestigacion;
    }
    
    @PostConstruct
    public void cargar(){
        setListaGruposInvestigacion(grupoBean.findAll());
    }
    public void eliminar(int idGrupo){
        FacesMessage message;
        Grupoinvestigacion grupoEliminar = grupoBean.find(idGrupo);
        try {
            grupoBean.eliminar(grupoEliminar);
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
