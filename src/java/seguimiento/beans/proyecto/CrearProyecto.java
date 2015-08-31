/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.proyecto;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import seguimiento.beans.semillero.detalleSemillero;
import seguimiento.beans.semillero.semilleroFacade;
import seguimiento.model.Proyectos;
import seguimiento.model.Semilleros;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class CrearProyecto {
    
    @ManagedProperty(value = "#{detallesemillero}")
    private detalleSemillero detallesemillero;
    
    private Proyectos proyecto;
    private Semilleros semille;
    @EJB
    private proyectoFacade proyectoBean;
    @EJB
    private semilleroFacade semilleroBean;

    public CrearProyecto() {
    }
    
    @PostConstruct
    public void cargar(){
        //setSemille(semilleroBean.find(2));
    }

    /**
     * @return the proyecto
     */
    public Proyectos getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @return the semille
     */
    public Semilleros getSemille() {
        if(semille==null){
            semille= new Semilleros();
        }
        return semille;
    }

    /**
     * @param semille the semille to set
     */
    public void setSemille(Semilleros semille) {
        this.semille = semille;
    }

}
