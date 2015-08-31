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
@Table(name = "documentosemillero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentosemillero.findAll", query = "SELECT d FROM Documentosemillero d"),
    @NamedQuery(name = "Documentosemillero.findByIddocumento", query = "SELECT d FROM Documentosemillero d WHERE d.iddocumento = :iddocumento"),
    @NamedQuery(name = "Documentosemillero.findByPathdocumento", query = "SELECT d FROM Documentosemillero d WHERE d.pathdocumento = :pathdocumento"),
    @NamedQuery(name = "Documentosemillero.findByDescripcion", query = "SELECT d FROM Documentosemillero d WHERE d.descripcion = :descripcion")})
public class Documentosemillero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocumento")
    private Integer iddocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "pathdocumento")
    private String pathdocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idsemillero", referencedColumnName = "idsemilleros")
    @ManyToOne(optional = false)
    private Semilleros idsemillero;

    public Documentosemillero() {
    }

    public Documentosemillero(Integer iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Documentosemillero(Integer iddocumento, String pathdocumento, String descripcion) {
        this.iddocumento = iddocumento;
        this.pathdocumento = pathdocumento;
        this.descripcion = descripcion;
    }

    public Integer getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Integer iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getPathdocumento() {
        return pathdocumento;
    }

    public void setPathdocumento(String pathdocumento) {
        this.pathdocumento = pathdocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Semilleros getIdsemillero() {
        return idsemillero;
    }

    public void setIdsemillero(Semilleros idsemillero) {
        this.idsemillero = idsemillero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumento != null ? iddocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentosemillero)) {
            return false;
        }
        Documentosemillero other = (Documentosemillero) object;
        if ((this.iddocumento == null && other.iddocumento != null) || (this.iddocumento != null && !this.iddocumento.equals(other.iddocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Documentosemillero[ iddocumento=" + iddocumento + " ]";
    }
    
}
