/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "objetivos_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjetivosProyecto.findAll", query = "SELECT o FROM ObjetivosProyecto o"),
    @NamedQuery(name = "ObjetivosProyecto.findByIdobjetivoproyecto", query = "SELECT o FROM ObjetivosProyecto o WHERE o.idobjetivoproyecto = :idobjetivoproyecto"),
    @NamedQuery(name = "ObjetivosProyecto.findByNombreobjetivo", query = "SELECT o FROM ObjetivosProyecto o WHERE o.nombreobjetivo = :nombreobjetivo")})
public class ObjetivosProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idobjetivoproyecto")
    private Integer idobjetivoproyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "nombreobjetivo")
    private String nombreobjetivo;
    @JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto")
    @ManyToOne(optional = false)
    private Proyectos idproyecto;

    public ObjetivosProyecto() {
    }

    public ObjetivosProyecto(Integer idobjetivoproyecto) {
        this.idobjetivoproyecto = idobjetivoproyecto;
    }

    public ObjetivosProyecto(Integer idobjetivoproyecto, String nombreobjetivo) {
        this.idobjetivoproyecto = idobjetivoproyecto;
        this.nombreobjetivo = nombreobjetivo;
    }

    public Integer getIdobjetivoproyecto() {
        return idobjetivoproyecto;
    }

    public void setIdobjetivoproyecto(Integer idobjetivoproyecto) {
        this.idobjetivoproyecto = idobjetivoproyecto;
    }

    public String getNombreobjetivo() {
        return nombreobjetivo;
    }

    public void setNombreobjetivo(String nombreobjetivo) {
        this.nombreobjetivo = nombreobjetivo;
    }

    public Proyectos getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Proyectos idproyecto) {
        this.idproyecto = idproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobjetivoproyecto != null ? idobjetivoproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivosProyecto)) {
            return false;
        }
        ObjetivosProyecto other = (ObjetivosProyecto) object;
        if ((this.idobjetivoproyecto == null && other.idobjetivoproyecto != null) || (this.idobjetivoproyecto != null && !this.idobjetivoproyecto.equals(other.idobjetivoproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.ObjetivosProyecto[ idobjetivoproyecto=" + idobjetivoproyecto + " ]";
    }
    
}
