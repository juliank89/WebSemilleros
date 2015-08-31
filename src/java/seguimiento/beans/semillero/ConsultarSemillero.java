/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.semillero;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import seguimiento.beans.categoria.categoriaFacade;
import seguimiento.beans.grupoinvestigacion.grupoInvestigacionFacade;
import seguimiento.model.Categoria;
import seguimiento.model.Grupoinvestigacion;
import seguimiento.model.Proyectos;
import seguimiento.model.Semilleros;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped 
public class ConsultarSemillero implements Serializable{

    private List<Semilleros> listaSemilleros;
    private List<Grupoinvestigacion> listaGrupos;
    private List<Categoria> listaCategoria;
    private Semilleros semilleroSeleccionado;
    private Proyectos proyectoSeleccionado;
    
    @EJB
    private semilleroFacade semilleroBean;
    @EJB
    private grupoInvestigacionFacade grupoBean;
    @EJB
    private categoriaFacade categoriaBean;
    
    public ConsultarSemillero() {
    }
    
    @PostConstruct
    public void cargar(){
        setListaSemilleros(semilleroBean.findAll());
        setListaGrupos(grupoBean.findAll());
        setListaCategoria(categoriaBean.findAll());
    }

    /**
     * @return the listaSemilleros
     */
    public List<Semilleros> getListaSemilleros() {
        return listaSemilleros;
    }

    /**
     * @param listaSemilleros the listaSemilleros to set
     */
    public void setListaSemilleros(List<Semilleros> listaSemilleros) {
        this.listaSemilleros = listaSemilleros;
    }

    /**
     * @return the listaGrupos
     */
    public List<Grupoinvestigacion> getListaGrupos() {
        return listaGrupos;
    }

    /**
     * @param listaGrupos the listaGrupos to set
     */
    public void setListaGrupos(List<Grupoinvestigacion> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    /**
     * @return the listaCategoria
     */
    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    /**
     * @param listaCategoria the listaCategoria to set
     */
    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    /**
     * @return the semilleroSeleccionado
     */
    public Semilleros getSemilleroSeleccionado() {
        return semilleroSeleccionado;
    }

    /**
     * @param semilleroSeleccionado the semilleroSeleccionado to set
     */
    public void setSemilleroSeleccionado(Semilleros semilleroSeleccionado) {
        this.semilleroSeleccionado = semilleroSeleccionado;
    }

    /**
     * @return the proyectoSeleccionado
     */
    public Proyectos getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    /**
     * @param proyectoSeleccionado the proyectoSeleccionado to set
     */
    public void setProyectoSeleccionado(Proyectos proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }
    
}
