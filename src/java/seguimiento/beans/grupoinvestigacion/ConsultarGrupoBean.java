/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.grupoinvestigacion;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import seguimiento.model.Grupoinvestigacion;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class ConsultarGrupoBean {

    @EJB
    private grupoInvestigacionFacade grupoBean;
    private List<Grupoinvestigacion> listaGruposInvestigacion;

    public ConsultarGrupoBean() {
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
    public void cargar() {
        setListaGruposInvestigacion(grupoBean.findAll());
    }

}
