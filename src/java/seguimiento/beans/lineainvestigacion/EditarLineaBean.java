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
import org.primefaces.event.RowEditEvent;
import seguimiento.beans.grupoinvestigacion.grupoInvestigacionFacade;
import seguimiento.model.Grupoinvestigacion;
import seguimiento.model.Lineainvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EditarLineaBean {

    @EJB
    private grupoInvestigacionFacade grupoBean;
    
    @EJB
    private LineaInvestigacionFacade lineaBean;
    private List<Lineainvestigacion> listaLineasInvestigacion;
    private List<Grupoinvestigacion> listaGruposInvestigacion;
    
    public EditarLineaBean() {
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
        setListaLineasInvestigacion(lineaBean.findAll());
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage message;
        
        Lineainvestigacion lineaEditar = lineaBean.find(((Lineainvestigacion) (event.getObject())).getIdlinea());
        lineaEditar.setNombrelinea(((Lineainvestigacion) (event.getObject())).getNombrelinea());
        lineaEditar.setDescripcion(((Lineainvestigacion) (event.getObject())).getDescripcion());
        lineaEditar.setIdgrupo(((Lineainvestigacion) (event.getObject())).getIdgrupo());
        
        try {
            lineaBean.editar(lineaEditar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }finally{
            setListaLineasInvestigacion(null);
            setListaGruposInvestigacion(null);
            cargar();
        }
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición Cancelada",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
