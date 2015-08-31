/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.semillero;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import seguimiento.beans.tipoproducto.tipoProductoFacade;
import seguimiento.model.ObjetivosProyecto;
import seguimiento.model.Productos;
import seguimiento.model.Proyectos;
import seguimiento.model.Semilleros;
import seguimiento.model.Tipoproducto;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class detalleSemillero implements Serializable {

    @ManagedProperty(value = "#{crearSemillero}")
    private CrearSemillero crearSemillero;

    @ManagedProperty(value = "#{consultarSemillero}")
    private ConsultarSemillero consultarSemillero;

    @EJB
    private semilleroFacade semilleroBean;
    @EJB
    private tipoProductoFacade tipoProductoBean;

    private Semilleros sem;
    private Proyectos proyectoSeleccionado;
    private static Proyectos proyectoCrear;
    private Productos productoCrear;
    private String objetivoProyecto;
    private static List<ObjetivosProyecto> listaObjetivosProyecto = new ArrayList<>();
    private List<Tipoproducto> listaTipoProductos = new ArrayList<>();


    public detalleSemillero() {
    }

    @PostConstruct
    public void cargar() {
        inicializarTipoProducto();
        if (sem == null) {
            if (crearSemillero.getSemilero().getIdsemilleros() != null) {
                setSem(semilleroBean.find(crearSemillero.getSemilero().getIdsemilleros()));
                setCrearSemillero(null);
                inicializarTipoProducto();
            } else if (consultarSemillero.getSemilleroSeleccionado() != null) {
                setSem(semilleroBean.find(consultarSemillero.getSemilleroSeleccionado().getIdsemilleros()));
                setConsultarSemillero(null);
                inicializarTipoProducto();
            } else {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/faces/semillero/consultarsemilleros.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(detalleSemillero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            int idSemillero = sem.getIdsemilleros();
            setSem(null);
            setSem(semilleroBean.find(idSemillero));
        }
    }

    public void inicializarTipoProducto() {
        setListaTipoProductos(null);
        setListaTipoProductos(tipoProductoBean.findAll());
    }

    /**
     * @return the consultarSemillero
     */
    public CrearSemillero getCrearSemillero() {

        return crearSemillero;
    }

    /**
     *
     * @param crearSemillero
     */
    public void setCrearSemillero(CrearSemillero crearSemillero) {
        this.crearSemillero = crearSemillero;
    }

    /**
     * @return the sem
     */
    public Semilleros getSem() {
        return sem;
    }

    /**
     * @param sem the sem to set
     */
    public void setSem(Semilleros sem) {
        this.sem = sem;
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

    /**
     * @return the proyectoCrear
     */
    public Proyectos getProyectoCrear() {
        if (proyectoCrear == null) {
            proyectoCrear = new Proyectos();
        }
        return proyectoCrear;
    }

    /**
     * @param proyectoCrear the proyectoCrear to set
     */
    public void setProyectoCrear(Proyectos proyectoCrear) {
        this.proyectoCrear = proyectoCrear;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    /**
     * @return the listaObjetivosProyecto
     */
    public List<ObjetivosProyecto> getListaObjetivosProyecto() {

        return listaObjetivosProyecto;
    }

    /**
     * @param listaObjetivosProyecto the listaObjetivosProyecto to set
     */
    public void setListaObjetivosProyecto(List<ObjetivosProyecto> listaObjetivosProyecto) {
        this.listaObjetivosProyecto = listaObjetivosProyecto;
    }

    public void agregarEspecificos(String aa) {
        FacesMessage message;
        System.out.println(objetivoProyecto);
        System.out.println(aa);
        ObjetivosProyecto objetivosProyecto = new ObjetivosProyecto();
        objetivosProyecto.setNombreobjetivo(getObjetivoProyecto());
        try {
            listaObjetivosProyecto.add(objetivosProyecto);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Objetivo Especifico Agregado", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    /**
     * @return the objetivoProyecto
     */
    public String getObjetivoProyecto() {
        return objetivoProyecto;
    }

    /**
     * @param objetivoProyecto the objetivoProyecto to set
     */
    public void setObjetivoProyecto(String objetivoProyecto) {
        this.objetivoProyecto = objetivoProyecto;
    }

    public void eliminarEspecifico(ObjetivosProyecto especificoItem) {
        int aas = -1;
        for (int i = 0; i < listaObjetivosProyecto.size(); i++) {
            if (listaObjetivosProyecto.get(i).getNombreobjetivo().compareTo(especificoItem.getNombreobjetivo()) == 0) {
                aas = i;
                listaObjetivosProyecto.remove(aas);
            }
        }
    }

    public void saveProyecto() {
        FacesMessage message;
        proyectoCrear.setEstado(false);
        proyectoCrear.setIdsemillero(getSem());
        for (ObjetivosProyecto obprp : listaObjetivosProyecto) {
            obprp.setIdproyecto(proyectoCrear);
        }
        proyectoCrear.setObjetivosProyectoCollection(listaObjetivosProyecto);
        try {
            sem.getProyectosCollection().add(proyectoCrear);
            semilleroBean.editar(sem);
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/semillero/detallesemillero.xhtml");
        } catch (IOException e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            limpiarProyecto();
        }
    }

    public void saveProducto() {
        FacesMessage message;
        productoCrear.setIdsemillero(getSem());
        try {
            //productoBean.crear(productoCrear);
            sem.getProductosCollection().add(productoCrear);
            semilleroBean.editar(sem);
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/semillero/detallesemillero.xhtml");
        } catch (IOException e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void limpiarProyecto() {
        proyectoCrear = null;
        proyectoCrear = new Proyectos();
    }


    /**
     * @return the consultarSemillero
     */
    public ConsultarSemillero getConsultarSemillero() {
        return consultarSemillero;
    }

    /**
     * @param consultarSemillero the consultarSemillero to set
     */
    public void setConsultarSemillero(ConsultarSemillero consultarSemillero) {
        this.consultarSemillero = consultarSemillero;
    }

    /**
     * @return the productoCrear
     */
    public Productos getProductoCrear() {
        if (productoCrear == null) {
            productoCrear = new Productos();
        }
        return productoCrear;
    }

    /**
     * @param productoCrear the productoCrear to set
     */
    public void setProductoCrear(Productos productoCrear) {
        this.productoCrear = productoCrear;
    }

    /**
     * @return the listaTipoProductos
     */
    public List<Tipoproducto> getListaTipoProductos() {

        return listaTipoProductos;
    }

    /**
     * @param listaTipoProductos the listaTipoProductos to set
     */
    public void setListaTipoProductos(List<Tipoproducto> listaTipoProductos) {
        this.listaTipoProductos = listaTipoProductos;
    }

    public void redireccionProyecto() {
        FacesMessage message;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/proyectos/crearproyecto.xhtml");
        } catch (IOException ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ah Ocurrido un Error", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void redireccionProducto() {
        FacesMessage message;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/productos/crearproducto.xhtml");
        } catch (IOException ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un Error", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
