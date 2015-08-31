/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "red")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Red.findAll", query = "SELECT r FROM Red r"),
    @NamedQuery(name = "Red.findByIdred", query = "SELECT r FROM Red r WHERE r.idred = :idred"),
    @NamedQuery(name = "Red.findByNombrered", query = "SELECT r FROM Red r WHERE r.nombrered = :nombrered"),
    @NamedQuery(name = "Red.findByUrl", query = "SELECT r FROM Red r WHERE r.url = :url"),
    @NamedQuery(name = "Red.findByContexto", query = "SELECT r FROM Red r WHERE r.contexto = :contexto"),
    @NamedQuery(name = "Red.findByDescripcion", query = "SELECT r FROM Red r WHERE r.descripcion = :descripcion")})
public class Red implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idred")
    private Integer idred;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrered")
    private String nombrered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "contexto")
    private String contexto;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "redCollection")
    private Collection<Semilleros> semillerosCollection;
    @JoinTable(name = "redareatematica", joinColumns = {
        @JoinColumn(name = "idred", referencedColumnName = "idred")}, inverseJoinColumns = {
        @JoinColumn(name = "idarea", referencedColumnName = "idarea")})
    @ManyToMany
    private Collection<Areatematica> areatematicaCollection;
    @OneToMany(mappedBy = "idred")
    private Collection<Contacto> contactoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idred")
    private Collection<Resultado> resultadoCollection;

    public Red() {
    }

    public Red(Integer idred) {
        this.idred = idred;
    }

    public Red(Integer idred, String nombrered, String url, String contexto) {
        this.idred = idred;
        this.nombrered = nombrered;
        this.url = url;
        this.contexto = contexto;
    }

    public Integer getIdred() {
        return idred;
    }

    public void setIdred(Integer idred) {
        this.idred = idred;
    }

    public String getNombrered() {
        return nombrered;
    }

    public void setNombrered(String nombrered) {
        this.nombrered = nombrered;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Semilleros> getSemillerosCollection() {
        return semillerosCollection;
    }

    public void setSemillerosCollection(Collection<Semilleros> semillerosCollection) {
        this.semillerosCollection = semillerosCollection;
    }

    @XmlTransient
    public Collection<Areatematica> getAreatematicaCollection() {
        return areatematicaCollection;
    }

    public void setAreatematicaCollection(Collection<Areatematica> areatematicaCollection) {
        this.areatematicaCollection = areatematicaCollection;
    }

    @XmlTransient
    public Collection<Contacto> getContactoCollection() {
        return contactoCollection;
    }

    public void setContactoCollection(Collection<Contacto> contactoCollection) {
        this.contactoCollection = contactoCollection;
    }

    @XmlTransient
    public Collection<Resultado> getResultadoCollection() {
        return resultadoCollection;
    }

    public void setResultadoCollection(Collection<Resultado> resultadoCollection) {
        this.resultadoCollection = resultadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idred != null ? idred.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Red)) {
            return false;
        }
        Red other = (Red) object;
        if ((this.idred == null && other.idred != null) || (this.idred != null && !this.idred.equals(other.idred))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Red[ idred=" + idred + " ]";
    }
    
}
