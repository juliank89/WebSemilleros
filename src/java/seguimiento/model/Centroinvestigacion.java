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
@Table(name = "centroinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centroinvestigacion.findAll", query = "SELECT c FROM Centroinvestigacion c"),
    @NamedQuery(name = "Centroinvestigacion.findByIdcentro", query = "SELECT c FROM Centroinvestigacion c WHERE c.idcentro = :idcentro"),
    @NamedQuery(name = "Centroinvestigacion.findByNombrecentro", query = "SELECT c FROM Centroinvestigacion c WHERE c.nombrecentro = :nombrecentro"),
    @NamedQuery(name = "Centroinvestigacion.findByDescripcion", query = "SELECT c FROM Centroinvestigacion c WHERE c.descripcion = :descripcion")})
public class Centroinvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcentro")
    private Integer idcentro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrecentro")
    private String nombrecentro;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcentro")
    private Collection<Grupoinvestigacion> grupoinvestigacionCollection;

    public Centroinvestigacion() {
    }

    public Centroinvestigacion(Integer idcentro) {
        this.idcentro = idcentro;
    }

    public Centroinvestigacion(Integer idcentro, String nombrecentro) {
        this.idcentro = idcentro;
        this.nombrecentro = nombrecentro;
    }

    public Integer getIdcentro() {
        return idcentro;
    }

    public void setIdcentro(Integer idcentro) {
        this.idcentro = idcentro;
    }

    public String getNombrecentro() {
        return nombrecentro;
    }

    public void setNombrecentro(String nombrecentro) {
        this.nombrecentro = nombrecentro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Grupoinvestigacion> getGrupoinvestigacionCollection() {
        return grupoinvestigacionCollection;
    }

    public void setGrupoinvestigacionCollection(Collection<Grupoinvestigacion> grupoinvestigacionCollection) {
        this.grupoinvestigacionCollection = grupoinvestigacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcentro != null ? idcentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centroinvestigacion)) {
            return false;
        }
        Centroinvestigacion other = (Centroinvestigacion) object;
        if ((this.idcentro == null && other.idcentro != null) || (this.idcentro != null && !this.idcentro.equals(other.idcentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Centroinvestigacion[ idcentro=" + idcentro + " ]";
    }
    
}
