/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.red;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import seguimiento.model.Red;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class ConsultarRedBean {

    @EJB
    private redFacade redBean;
    
    private List<Red> listaRedesInvestigacion;
    public ConsultarRedBean() {
    }
    
    @PostConstruct
    public void cargar(){
        setListaRedesInvestigacion(null);
        setListaRedesInvestigacion(redBean.findAll());
    }

    /**
     * @return the listaRedesInvestigacion
     */
    public List<Red> getListaRedesInvestigacion() {
        return listaRedesInvestigacion;
    }

    /**
     * @param listaRedesInvestigacion the listaRedesInvestigacion to set
     */
    public void setListaRedesInvestigacion(List<Red> listaRedesInvestigacion) {
        this.listaRedesInvestigacion = listaRedesInvestigacion;
    }
    
}
