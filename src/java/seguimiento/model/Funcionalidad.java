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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "funcionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT f FROM Funcionalidad f"),
    @NamedQuery(name = "Funcionalidad.findByIdfuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.idfuncionalidad = :idfuncionalidad"),
    @NamedQuery(name = "Funcionalidad.findByNombrefuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.nombrefuncionalidad = :nombrefuncionalidad")})
public class Funcionalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionalidad")
    private Integer idfuncionalidad;
    @Basic(optional = false)
    @Column(name = "nombrefuncionalidad")
    private int nombrefuncionalidad;
    @JoinTable(name = "rolfuncionalidad", joinColumns = {
        @JoinColumn(name = "idfuncionalidad", referencedColumnName = "idfuncionalidad")}, inverseJoinColumns = {
        @JoinColumn(name = "idrol", referencedColumnName = "idrol")})
    @ManyToMany
    private Collection<Rol> rolCollection;

    public Funcionalidad() {
    }

    public Funcionalidad(Integer idfuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
    }

    public Funcionalidad(Integer idfuncionalidad, int nombrefuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
        this.nombrefuncionalidad = nombrefuncionalidad;
    }

    public Integer getIdfuncionalidad() {
        return idfuncionalidad;
    }

    public void setIdfuncionalidad(Integer idfuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
    }

    public int getNombrefuncionalidad() {
        return nombrefuncionalidad;
    }

    public void setNombrefuncionalidad(int nombrefuncionalidad) {
        this.nombrefuncionalidad = nombrefuncionalidad;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionalidad != null ? idfuncionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidad)) {
            return false;
        }
        Funcionalidad other = (Funcionalidad) object;
        if ((this.idfuncionalidad == null && other.idfuncionalidad != null) || (this.idfuncionalidad != null && !this.idfuncionalidad.equals(other.idfuncionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Funcionalidad[ idfuncionalidad=" + idfuncionalidad + " ]";
    }
    
}
