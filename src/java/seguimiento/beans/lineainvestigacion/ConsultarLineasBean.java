/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.lineainvestigacion;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import seguimiento.model.Lineainvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class ConsultarLineasBean {

    @EJB
    private LineaInvestigacionFacade lineaBean;
    private List<Lineainvestigacion> listaLineasInvestigacion;

    public ConsultarLineasBean() {
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
    
    @PostConstruct
    public void cargar(){
        setListaLineasInvestigacion(lineaBean.findAll());
    }
}
