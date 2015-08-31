/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "semilleros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semilleros.findAll", query = "SELECT s FROM Semilleros s"),
    @NamedQuery(name = "Semilleros.findByIdsemilleros", query = "SELECT s FROM Semilleros s WHERE s.idsemilleros = :idsemilleros"),
    @NamedQuery(name = "Semilleros.findByNombresemillero", query = "SELECT s FROM Semilleros s WHERE s.nombresemillero = :nombresemillero"),
    @NamedQuery(name = "Semilleros.findByEstado", query = "SELECT s FROM Semilleros s WHERE s.estado = :estado"),
    @NamedQuery(name = "Semilleros.findByPathacta", query = "SELECT s FROM Semilleros s WHERE s.pathacta = :pathacta"),
    @NamedQuery(name = "Semilleros.findByFechaacta", query = "SELECT s FROM Semilleros s WHERE s.fechaacta = :fechaacta")})
public class Semilleros implements Serializable {
    @ManyToMany(mappedBy = "semillerosCollection")
    private Collection<Persona> personaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsemillero")
    private Collection<Productos> productosCollection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "mision")
    private String mision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "vision")
    private String vision;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsemilleros")
    private Integer idsemilleros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombresemillero")
    private String nombresemillero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Size( max = 5000)
    @Column(name = "pathacta")
    private String pathacta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaacta")
    @Temporal(TemporalType.DATE)
    private Date fechaacta;
    @JoinTable(name = "semillerored", 
            joinColumns = {@JoinColumn(name = "idsemillero", referencedColumnName = "idsemilleros")}, 
            inverseJoinColumns = {@JoinColumn(name = "idred", referencedColumnName = "idred")})
    @ManyToMany
    private Collection<Red> redCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsemillero")
    private Collection<Proyectos> proyectosCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsemillero")
    private Collection<Informe> informeCollection;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = false)
    private Grupoinvestigacion idgrupo;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsemillero")
    private Collection<Documentosemillero> documentosemilleroCollection;

    public Semilleros() {
    }

    public Semilleros(Integer idsemilleros) {
        this.idsemilleros = idsemilleros;
    }

    public Semilleros(Integer idsemilleros, String nombresemillero, boolean estado, String pathacta, Date fechaacta) {
        this.idsemilleros = idsemilleros;
        this.nombresemillero = nombresemillero;
        this.estado = estado;
        this.pathacta = pathacta;
        this.fechaacta = fechaacta;
    }

    public Integer getIdsemilleros() {
        return idsemilleros;
    }

    public void setIdsemilleros(Integer idsemilleros) {
        this.idsemilleros = idsemilleros;
    }

    public String getNombresemillero() {
        return nombresemillero;
    }

    public void setNombresemillero(String nombresemillero) {
        this.nombresemillero = nombresemillero;
    }
    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPathacta() {
        return pathacta;
    }

    public void setPathacta(String pathacta) {
        this.pathacta = pathacta;
    }

    public Date getFechaacta() {
        return fechaacta;
    }

    public void setFechaacta(Date fechaacta) {
        this.fechaacta = fechaacta;
    }

    @XmlTransient
    public Collection<Red> getRedCollection() {
        return redCollection;
    }

    public void setRedCollection(Collection<Red> redCollection) {
        this.redCollection = redCollection;
    }

    @XmlTransient
    public Collection<Proyectos> getProyectosCollection() {
        return proyectosCollection;
    }

    public void setProyectosCollection(Collection<Proyectos> proyectosCollection) {
        this.proyectosCollection = proyectosCollection;
    }

    @XmlTransient
    public Collection<Informe> getInformeCollection() {
        return informeCollection;
    }

    public void setInformeCollection(Collection<Informe> informeCollection) {
        this.informeCollection = informeCollection;
    }

    public Grupoinvestigacion getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Grupoinvestigacion idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @XmlTransient
    public Collection<Documentosemillero> getDocumentosemilleroCollection() {
        return documentosemilleroCollection;
    }

    public void setDocumentosemilleroCollection(Collection<Documentosemillero> documentosemilleroCollection) {
        this.documentosemilleroCollection = documentosemilleroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsemilleros != null ? idsemilleros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semilleros)) {
            return false;
        }
        Semilleros other = (Semilleros) object;
        if ((this.idsemilleros == null && other.idsemilleros != null) || (this.idsemilleros != null && !this.idsemilleros.equals(other.idsemilleros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Semilleros[ idsemilleros=" + idsemilleros + " ]";
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }
    
}
