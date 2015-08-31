/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.persona;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import seguimiento.model.Persona;
import seguimiento.model.util.Tipodoc;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class crearPersonaBean {

    private Persona persona;
    @EJB
    private personaFacade personaBean;
    private List<String> tipoDocumento;

    /**
     * Creates a new instance of crearPersonaBean
     */
    public crearPersonaBean() {
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * @return the tipoDocumento
     */
    public List<String> getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(List<String> tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @PostConstruct
    public void Cargar() {
        List<String> aux= new ArrayList<>();
        for(Tipodoc td:Tipodoc.values()){
            aux.add(td.toString());
        }
        setTipoDocumento(aux);
    }

    public void crearPersona(ActionEvent actionEvent) {
        FacesMessage message;
        
        try {
            personaBean.crear(persona);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Persona Ingresada correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
