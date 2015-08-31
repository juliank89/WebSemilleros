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
@Table(name = "grupoinvestigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoinvestigacion.findAll", query = "SELECT g FROM Grupoinvestigacion g"),
    @NamedQuery(name = "Grupoinvestigacion.findByIdgrupo", query = "SELECT g FROM Grupoinvestigacion g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "Grupoinvestigacion.findByNombregrupo", query = "SELECT g FROM Grupoinvestigacion g WHERE g.nombregrupo = :nombregrupo"),
    @NamedQuery(name = "Grupoinvestigacion.findByDescripcion", query = "SELECT g FROM Grupoinvestigacion g WHERE g.descripcion = :descripcion")})
public class Grupoinvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupo")
    private Integer idgrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombregrupo")
    private String nombregrupo;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupo")
    private Collection<Lineainvestigacion> lineainvestigacionCollection;
    @JoinColumn(name = "idcentro", referencedColumnName = "idcentro")
    @ManyToOne(optional = false)
    private Centroinvestigacion idcentro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupo")
    private Collection<Semilleros> semillerosCollection;

    public Grupoinvestigacion() {
    }

    public Grupoinvestigacion(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Grupoinvestigacion(Integer idgrupo, String nombregrupo) {
        this.idgrupo = idgrupo;
        this.nombregrupo = nombregrupo;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Lineainvestigacion> getLineainvestigacionCollection() {
        return lineainvestigacionCollection;
    }

    public void setLineainvestigacionCollection(Collection<Lineainvestigacion> lineainvestigacionCollection) {
        this.lineainvestigacionCollection = lineainvestigacionCollection;
    }

    public Centroinvestigacion getIdcentro() {
        return idcentro;
    }

    public void setIdcentro(Centroinvestigacion idcentro) {
        this.idcentro = idcentro;
    }

    @XmlTransient
    public Collection<Semilleros> getSemillerosCollection() {
        return semillerosCollection;
    }

    public void setSemillerosCollection(Collection<Semilleros> semillerosCollection) {
        this.semillerosCollection = semillerosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupo != null ? idgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoinvestigacion)) {
            return false;
        }
        Grupoinvestigacion other = (Grupoinvestigacion) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Grupoinvestigacion[ idgrupo=" + idgrupo + " ]";
    }
    
}
