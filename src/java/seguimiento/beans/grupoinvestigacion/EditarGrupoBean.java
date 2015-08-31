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
import org.primefaces.event.RowEditEvent;
import seguimiento.beans.centroinvestigacion.centroInvestigacionFacade;
import seguimiento.model.Centroinvestigacion;
import seguimiento.model.Grupoinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EditarGrupoBean {

    @EJB
    private grupoInvestigacionFacade grupoBean;
    @EJB
    private centroInvestigacionFacade centroBean;
    private List<Centroinvestigacion> listaCentrosInvestigacion;
    private List<Grupoinvestigacion> listaGruposInvestigacion;

    public EditarGrupoBean() {
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
    public void cargar() {
        setListaGruposInvestigacion(grupoBean.findAll());
        setListaCentrosInvestigacion(centroBean.findAll());
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage message;
        Grupoinvestigacion grupoEditar= grupoBean.find(((Grupoinvestigacion)(event.getObject())).getIdgrupo());
        grupoEditar.setNombregrupo(((Grupoinvestigacion) (event.getObject())).getNombregrupo());
        grupoEditar.setDescripcion(((Grupoinvestigacion) (event.getObject())).getDescripcion());
        grupoEditar.setIdcentro(((Grupoinvestigacion) (event.getObject())).getIdcentro());

        try {
            grupoBean.editar(grupoEditar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            setListaCentrosInvestigacion(null);
            setListaGruposInvestigacion(null);
            cargar();
        }
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición Cancelada", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
