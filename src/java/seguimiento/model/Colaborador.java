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
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findByIdcolaborador", query = "SELECT c FROM Colaborador c WHERE c.idcolaborador = :idcolaborador"),
    @NamedQuery(name = "Colaborador.findByNombre", query = "SELECT c FROM Colaborador c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Colaborador.findByDescripcion", query = "SELECT c FROM Colaborador c WHERE c.descripcion = :descripcion")})
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcolaborador")
    private Integer idcolaborador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idinforme", referencedColumnName = "idinforme")
    @ManyToOne(optional = false)
    private Informe idinforme;

    public Colaborador() {
    }

    public Colaborador(Integer idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public Colaborador(Integer idcolaborador, String nombre) {
        this.idcolaborador = idcolaborador;
        this.nombre = nombre;
    }

    public Integer getIdcolaborador() {
        return idcolaborador;
    }

    public void setIdcolaborador(Integer idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Informe getIdinforme() {
        return idinforme;
    }

    public void setIdinforme(Informe idinforme) {
        this.idinforme = idinforme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcolaborador != null ? idcolaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.idcolaborador == null && other.idcolaborador != null) || (this.idcolaborador != null && !this.idcolaborador.equals(other.idcolaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Colaborador[ idcolaborador=" + idcolaborador + " ]";
    }
    
}
