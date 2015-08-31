/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.red;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import seguimiento.beans.areatematica.areaTematicaFacade;
import seguimiento.beans.contacto.contactoFacade;
import seguimiento.model.Areatematica;
import seguimiento.model.Contacto;
import seguimiento.model.Red;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class EditarRedBean {

    @EJB
    private redFacade redBean;
    @EJB
    private areaTematicaFacade areaBean;
    @EJB
    private contactoFacade contactoBean;

    private List<Red> listaRedesInvestigacion;
    private List<Areatematica> listaAreas;
    private List<Areatematica> listaAreasSeleccion;
    private Contacto auxcontacto;
    private String telefonoContacto;
    private static Red redas;

    public EditarRedBean() {
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

    /**
     * @return the listaAreas
     */
    public List<Areatematica> getListaAreas() {
        return listaAreas;
    }

    /**
     * @param listaAreas the listaAreas to set
     */
    public void setListaAreas(List<Areatematica> listaAreas) {
        this.listaAreas = listaAreas;
    }

    /**
     * @return the listaAreasSeleccion
     */
    public List<Areatematica> getListaAreasSeleccion() {
        return listaAreasSeleccion;
    }

    /**
     * @param listaAreasSeleccion the listaAreasSeleccion to set
     */
    public void setListaAreasSeleccion(List<Areatematica> listaAreasSeleccion) {
        this.listaAreasSeleccion = listaAreasSeleccion;
    }

    /**
     * @return the auxcontacto
     */
    public Contacto getAuxcontacto() {
        if (auxcontacto == null) {
            auxcontacto = new Contacto();
        }
        return auxcontacto;
    }

    /**
     * @param auxcontacto the auxcontacto to set
     */
    public void setAuxcontacto(Contacto auxcontacto) {
        this.auxcontacto = auxcontacto;
    }

    /**
     * @return the telefonoContacto
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * @param telefonoContacto the telefonoContacto to set
     */
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @PostConstruct
    public void cargar() {
        setListaRedesInvestigacion(null);
        setListaRedesInvestigacion(redBean.findAll());
        setListaAreas(areaBean.findAll());
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage message;

        Red redEditar = redBean.find(((Red) (event.getObject())).getIdred());
        redEditar.setNombrered(((Red) (event.getObject())).getNombrered());
        redEditar.setDescripcion(((Red) (event.getObject())).getDescripcion());
        redEditar.setUrl(((Red) (event.getObject())).getUrl());
        redEditar.setContexto(((Red) (event.getObject())).getContexto());

        try {
            redBean.editar(redEditar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            cargar();
        }
    }

    public void onRowEditContacto(RowEditEvent event) {
        FacesMessage message;
        Contacto contactoEditar = contactoBean.find(((Contacto) (event.getObject())).getIdcontacto());
        contactoEditar.setDireccion(((Contacto) (event.getObject())).getDireccion());
        contactoEditar.setMail(((Contacto) (event.getObject())).getMail());
        contactoEditar.setNombre(((Contacto) (event.getObject())).getNombre());
        contactoEditar.setTelefono(((Contacto) (event.getObject())).getTelefono());

        try {
            contactoBean.editar(contactoEditar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            cargar();
        }
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición Cancelada", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void eliminar(int idContactoRed) {
        FacesMessage message;
        Contacto contactoEliminar = contactoBean.find(idContactoRed);
        try {
            contactoBean.eliminar(contactoEliminar);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            cargar();
        }
    }
    
    public void fdf(Red asd){
        setRedas(asd);
    }

    public void crearContacto(Red auxred) {
        FacesMessage message;
        auxcontacto.setTelefono(BigInteger.valueOf(Long.valueOf(telefonoContacto)));
        try {
            contactoBean.crear(auxcontacto);
        } catch (Exception e) {
        }
    }

    /**
     * @return the redas
     */
    public Red getRedas() {
        return redas;
    }

    /**
     * @param redas the redas to set
     */
    public void setRedas(Red redas) {
        this.redas = redas;
    }
}
