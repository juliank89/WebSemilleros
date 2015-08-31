/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "areatematica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areatematica.findAll", query = "SELECT a FROM Areatematica a"),
    @NamedQuery(name = "Areatematica.findByIdarea", query = "SELECT a FROM Areatematica a WHERE a.idarea = :idarea"),
    @NamedQuery(name = "Areatematica.findByNombrearea", query = "SELECT a FROM Areatematica a WHERE a.nombrearea = :nombrearea"),
    @NamedQuery(name = "Areatematica.findByDescripcion", query = "SELECT a FROM Areatematica a WHERE a.descripcion = :descripcion")})
public class Areatematica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarea")
    private Integer idarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrearea")
    private String nombrearea;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "areatematicaCollection")
    private Collection<Red> redCollection;

    public Areatematica() {
    }

    public Areatematica(Integer idarea) {
        this.idarea = idarea;
    }

    public Areatematica(Integer idarea, String nombrearea) {
        this.idarea = idarea;
        this.nombrearea = nombrearea;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    public String getNombrearea() {
        return nombrearea;
    }

    public void setNombrearea(String nombrearea) {
        this.nombrearea = nombrearea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Red> getRedCollection() {
        return redCollection;
    }

    public void setRedCollection(Collection<Red> redCollection) {
        this.redCollection = redCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarea != null ? idarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areatematica)) {
            return false;
        }
        Areatematica other = (Areatematica) object;
        if ((this.idarea == null && other.idarea != null) || (this.idarea != null && !this.idarea.equals(other.idarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Areatematica[ idarea=" + idarea + " ]";
    }
    
}
