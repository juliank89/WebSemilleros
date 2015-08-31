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
@Table(name = "resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByIdresultado", query = "SELECT r FROM Resultado r WHERE r.idresultado = :idresultado"),
    @NamedQuery(name = "Resultado.findByDescripcion", query = "SELECT r FROM Resultado r WHERE r.descripcion = :descripcion")})
public class Resultado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresultado")
    private Integer idresultado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idred", referencedColumnName = "idred")
    @ManyToOne(optional = false)
    private Red idred;
    @JoinColumn(name = "idinforme", referencedColumnName = "idinforme")
    @ManyToOne(optional = false)
    private Informe idinforme;

    public Resultado() {
    }

    public Resultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public Resultado(Integer idresultado, String descripcion) {
        this.idresultado = idresultado;
        this.descripcion = descripcion;
    }

    public Integer getIdresultado() {
        return idresultado;
    }

    public void setIdresultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Red getIdred() {
        return idred;
    }

    public void setIdred(Red idred) {
        this.idred = idred;
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
        hash += (idresultado != null ? idresultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.idresultado == null && other.idresultado != null) || (this.idresultado != null && !this.idresultado.equals(other.idresultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Resultado[ idresultado=" + idresultado + " ]";
    }
    
}
