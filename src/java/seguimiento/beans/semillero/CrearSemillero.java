/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.semillero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.EventListener;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import org.primefaces.model.UploadedFile;
import seguimiento.beans.categoria.categoriaFacade;
import seguimiento.beans.grupoinvestigacion.grupoInvestigacionFacade;
import seguimiento.beans.red.redFacade;
import seguimiento.model.Categoria;
import seguimiento.model.Grupoinvestigacion;
import seguimiento.model.Red;
import seguimiento.model.Semilleros;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class CrearSemillero implements Serializable {

    private Semilleros semilero;
    private List<Grupoinvestigacion> listaGrupos;
    private List<Categoria> listaCategoria;
    private List<Red> listaRedes;
    @EJB
    private semilleroFacade semilleroBean;
    @EJB
    private grupoInvestigacionFacade grupoBean;
    @EJB
    private categoriaFacade categoriaBean;
    @EJB
    private redFacade redBean;

    private UploadedFile file;

    public CrearSemillero() {
    }
    
    @PostConstruct
    public void cargar() {
        setListaGrupos(grupoBean.findAll());
        setListaCategoria(categoriaBean.findAll());
        setListaRedes(redBean.findAll());
    }

    /**
     * @return the semilero
     */
    public Semilleros getSemilero() {
        if (semilero == null) {
            semilero = new Semilleros();
        }
        return semilero;
    }

    /**
     * @param semilero the semilero to set
     */
    public void setSemilero(Semilleros semilero) {
        this.semilero = semilero;
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
     * @return the listaRedes
     */
    public List<Red> getListaRedes() {
        return listaRedes;
    }

    /**
     * @param listaRedes the listaRedes to set
     */
    public void setListaRedes(List<Red> listaRedes) {
        this.listaRedes = listaRedes;
    }

    

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String upload() {
        String destination = "";

        try {
            destination = copyFile(getFile().getFileName(), getFile().getInputstream());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(destination);
        return destination;

    }

    public String copyFile(String fileName, InputStream in) {
        OutputStream out;

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String Carpeta = (String) servletContext.getRealPath("/upload/");
        String df = (String) servletContext.getContextPath() + "/upload/";
        String nombreFile = "/acta_" + semilero.getIdsemilleros().toString()+ "_" + semilero.getNombresemillero().toString().replace(' ', '_') +  ".pdf";

        try {
            out = new FileOutputStream(new File( Carpeta + nombreFile));

            int read;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return nombreFile;
    }

    public void guardar(EventListener eventListener) {
        FacesMessage message;
        semilero.setEstado(false);
        try {
            semilleroBean.crear(semilero);
            semilero.setPathacta(upload());
            semilleroBean.editar(semilero);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/faces/semillero/detallesemillero.xhtml" );
//            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Semillero Ingresada correctamente", null);
//            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el formulario", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void validarArchivo(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        UploadedFile as = (UploadedFile) o;
        
        if ((as.getContentType().compareTo("application/save-as") == 0)||
                ((as.getContentType().compareTo("application/pdf")== 0))) {
        } else {
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Formato de archivo invalido, el archivo debe ser de formato \"pdf\"", null));
        }
    }
}
