/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.red;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.event.FlowEvent;
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
public class CrearRedBean{

    private String[] contexto;
    private List<Areatematica> listaAreasTematicas;
    private static List<Areatematica> listaAreasTematicasSeleccion = new ArrayList<>();
    private static List<Contacto> listaContactos = new ArrayList<>();
    private static String contextoRed;
    private String telefonoContacto;
    @EJB
    private areaTematicaFacade areaBean;
    @EJB
    private redFacade redBean;
    @EJB
    private contactoFacade contactoBean;
    private static Red red;
    private static Contacto cont;
    
    /**
     * Constructor de ManageBean de Crear Red de Investigación
     */
    public CrearRedBean() {
        //cargar();
    }

    /**
     * @return the contexto
     */
    public String[] getContexto() {
        return contexto;
    }

    /**
     * @param contexto the contexto to set
     */
    public void setContexto(String[] contexto) {
        
        if (contexto.length == 1) {
            if (contexto[0].compareTo("I") == 0) {
                red.setContexto("I");
                setContextoRed("Internacional");
            } else {
                red.setContexto("N");
                setContextoRed("Nacional");
            }
        } else if (contexto.length > 1) {
            red.setContexto("A");
            setContextoRed("Nacional e Internacional");
        } else {
            setContextoRed("Ninguno");
        }
        
        this.contexto = contexto;
    }

    /**
     * @return the listaAreasTematicas
     */
    public List<Areatematica> getListaAreasTematicas() {
        return listaAreasTematicas;
    }

    /**
     * @param listaAreasTematicas the listaAreasTematicas to set
     */
    public void setListaAreasTematicas(List<Areatematica> listaAreasTematicas) {
        this.listaAreasTematicas = listaAreasTematicas;
    }

    /**
     * @return the listaAreasTematicasSeleccion
     */
    public List<Areatematica> getListaAreasTematicasSeleccion() {
        return listaAreasTematicasSeleccion;
    }

    /**
     * @param listaAreasTematicasSeleccion the listaAreasTematicasSeleccion to
     * set
     */
    public void setListaAreasTematicasSeleccion(List<Areatematica> listaAreasTematicasSeleccion) {
        CrearRedBean.listaAreasTematicasSeleccion = listaAreasTematicasSeleccion;
    }

    /**
     * @return the listaContactos
     */
    public List<Contacto> getListaContactos() {
        return listaContactos;
    }

    /**
     * @param listaContactos the listaContactos to set
     */
    public void setListaContactos(List<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }
    
    /**
     * @return the contextoRed
     */
    public String getContextoRed() {
        return contextoRed;
    }

    /**
     * @param contextoRed the contextoRed to set
     */
    public void setContextoRed(String contextoRed) {
        this.contextoRed = contextoRed;
    }

    /**
     * @return the red
     */
    public Red getRed() {
        if(red==null){
            red= new Red();
        }
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(Red red) {
        this.red = red;
    }
    
    /**
     * @return the cont
     */
    public  Contacto getCont() {
        if(cont==null){
            cont = new Contacto();
        }
        return cont;
    }

    /**
     * @param aCont the cont to set
     */
    public  void setCont(Contacto aCont) {
        cont = aCont;
    }
    
    /**
     * Inicializador de variable para contacto
     */
    public void inicializarContacto() {
        setCont(null);
        setCont(new Contacto());
        getCont().setNombre(" ");
        setTelefonoContacto(" ");
    }
    
    /**
     * Inicializador de las variables y listas usadas
     */
    public void inicializar(){
        setRed(null);
        setRed(new Red());
        setListaAreasTematicasSeleccion(null);
        setListaAreasTematicasSeleccion(new ArrayList<Areatematica>());
        setCont(null);
        setCont(new Contacto());
        setListaContactos(null);
        setListaContactos(new ArrayList<Contacto>());
    }

    /**
     * Funcion para crear identificador dentro del formulario y asigna  
     * el valor correcto a la variable contexto
     */
    public void contextoInicializadorRed() {
        if (contexto.length == 1) {
            if (contexto[0].compareTo("I") == 0) {
                red.setContexto("I");
                setContextoRed("Internacional");
            } else {
                red.setContexto("N");
                setContextoRed("Nacional");
            }
        } else if (contexto.length > 1) {
            red.setContexto("A");
            setContextoRed("Nacional e Internacional");
        } else {
            setContextoRed("Ninguno");
        }
    }
    
    /**
     * Funcion para inicializar las areas y poderlas seleccionar en el formulario
     */
    public void inicializarAreas(){
        List<Areatematica> tmpArea= new ArrayList<>();
        for(Areatematica areaSel:listaAreasTematicasSeleccion){
            tmpArea.add(areaBean.find(areaSel.getIdarea()));
        }
        red.setAreatematicaCollection(tmpArea);
    }

    /**
     * Función para cargar informacion inicial del formulario
     */
    @PostConstruct
    public void cargar() {
        inicializar();
        setListaAreasTematicas(areaBean.findAll());
    }

    /**
     * Evento que permite el flujo de pestañas en la creacion de una red de 
     * investigacion 
     * @param event
     * @return nombre del siguiente paso del flujo entre pestañas
     */
    public String onFlowProcess(FlowEvent event) {
        
        if(event.getOldStep().compareTo("areas")==0){
            inicializarAreas();
        }
        return event.getNewStep();
    }

    /**
     * Evento de foton para crear una lista con los contactos de una red de investigación
     * @param actionEvent 
     */
    public void nuevoContacto(ActionEvent actionEvent) {

        FacesMessage message;
        
        try {
            cont.setTelefono(BigInteger.valueOf(Long.valueOf(telefonoContacto)));
            listaContactos.add(cont);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contacto agregado", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            inicializarContacto();
        }
    }
    
    /**
     * Evento de boton para crear una red de investigación
     * @param actionEvent 
     */
    public void CrearRed(ActionListener actionEvent) {

        FacesMessage message;
        try {
            Red idred=redBean.crearR(red);
            
            for (Contacto listaContacto : listaContactos) {
                listaContacto.setIdred(idred);
            }
            for (Contacto listaContacto : listaContactos) {
                contactoBean.crear(listaContacto);
            }
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Red Ingresada correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }finally{
            inicializar();
        }
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
}