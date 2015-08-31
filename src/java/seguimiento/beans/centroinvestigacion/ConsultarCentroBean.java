/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.centroinvestigacion;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import seguimiento.model.Centroinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class ConsultarCentroBean {

    @EJB
    private centroInvestigacionFacade centroBean;
    private List<Centroinvestigacion> listaCentrosInvestigacion;

    public ConsultarCentroBean() {
    }

    @PostConstruct
    public void cargar() {
        setListaCentrosInvestigacion(centroBean.findAll());
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
}
