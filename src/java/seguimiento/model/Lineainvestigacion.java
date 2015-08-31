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
import javax.persistence.ManyToOne;
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
@Table(name = "lineainvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineainvestigacion.findAll", query = "SELECT l FROM Lineainvestigacion l"),
    @NamedQuery(name = "Lineainvestigacion.findByIdlinea", query = "SELECT l FROM Lineainvestigacion l WHERE l.idlinea = :idlinea"),
    @NamedQuery(name = "Lineainvestigacion.findByNombrelinea", query = "SELECT l FROM Lineainvestigacion l WHERE l.nombrelinea = :nombrelinea"),
    @NamedQuery(name = "Lineainvestigacion.findByDescripcion", query = "SELECT l FROM Lineainvestigacion l WHERE l.descripcion = :descripcion")})
public class Lineainvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlinea")
    private Integer idlinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrelinea")
    private String nombrelinea;
    @Size(max = 400)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = false)
    private Grupoinvestigacion idgrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlinea")
    private Collection<Proyectos> proyectosCollection;

    public Lineainvestigacion() {
    }

    public Lineainvestigacion(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public Lineainvestigacion(Integer idlinea, String nombrelinea) {
        this.idlinea = idlinea;
        this.nombrelinea = nombrelinea;
    }

    public Integer getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public String getNombrelinea() {
        return nombrelinea;
    }

    public void setNombrelinea(String nombrelinea) {
        this.nombrelinea = nombrelinea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Grupoinvestigacion getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Grupoinvestigacion idgrupo) {
        this.idgrupo = idgrupo;
    }

    @XmlTransient
    public Collection<Proyectos> getProyectosCollection() {
        return proyectosCollection;
    }

    public void setProyectosCollection(Collection<Proyectos> proyectosCollection) {
        this.proyectosCollection = proyectosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlinea != null ? idlinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineainvestigacion)) {
            return false;
        }
        Lineainvestigacion other = (Lineainvestigacion) object;
        if ((this.idlinea == null && other.idlinea != null) || (this.idlinea != null && !this.idlinea.equals(other.idlinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Lineainvestigacion[ idlinea=" + idlinea + " ]";
    }
    
}
