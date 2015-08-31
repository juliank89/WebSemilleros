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
import javax.faces.event.ActionListener;
import seguimiento.beans.grupoinvestigacion.grupoInvestigacionFacade;
import seguimiento.model.Grupoinvestigacion;
import seguimiento.model.Lineainvestigacion;

/**
 *
 * @author JULIAN
 */
@ManagedBean
@RequestScoped
public class CrearLineaBean {

    private Lineainvestigacion lineaInvestigacion;
    private List<Grupoinvestigacion> listaGruposInvestigacion;

    @EJB
    private grupoInvestigacionFacade grupoBean;
    
    @EJB
    private LineaInvestigacionFacade lineaBean;
    
    public CrearLineaBean() {
        //cargar();
    }
    
    /**
     * @return the lineaInvestigacion
     */
    public Lineainvestigacion getLineaInvestigacion() {
        if(lineaInvestigacion==null){
            lineaInvestigacion = new Lineainvestigacion();
        }
        return lineaInvestigacion;
    }

    /**
     * @param lineaInvestigacion the lineaInvestigacion to set
     */
    public void setLineaInvestigacion(Lineainvestigacion lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
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
    
    public void CrearLinea(ActionListener actionEvent) {
        
        FacesMessage message;
        try {
            lineaBean.crear(lineaInvestigacion);
            //int idLinea = lineaBean.crearLinea(nombreLinea, descripcionLinea, grupoInvestigacion);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Investigación Ingresada correctamente",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    
}
