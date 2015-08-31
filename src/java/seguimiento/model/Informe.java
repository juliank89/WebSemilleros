/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informe.findAll", query = "SELECT i FROM Informe i"),
    @NamedQuery(name = "Informe.findByIdinforme", query = "SELECT i FROM Informe i WHERE i.idinforme = :idinforme"),
    @NamedQuery(name = "Informe.findByFecha", query = "SELECT i FROM Informe i WHERE i.fecha = :fecha")})
public class Informe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinforme")
    private Integer idinforme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinforme")
    private Collection<Actividad> actividadCollection;
    @JoinColumn(name = "idsemillero", referencedColumnName = "idsemilleros")
    @ManyToOne(optional = false)
    private Semilleros idsemillero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinforme")
    private Collection<Colaborador> colaboradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinforme")
    private Collection<Resultado> resultadoCollection;

    public Informe() {
    }

    public Informe(Integer idinforme) {
        this.idinforme = idinforme;
    }

    public Informe(Integer idinforme, Date fecha) {
        this.idinforme = idinforme;
        this.fecha = fecha;
    }

    public Integer getIdinforme() {
        return idinforme;
    }

    public void setIdinforme(Integer idinforme) {
        this.idinforme = idinforme;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    public Semilleros getIdsemillero() {
        return idsemillero;
    }

    public void setIdsemillero(Semilleros idsemillero) {
        this.idsemillero = idsemillero;
    }

    @XmlTransient
    public Collection<Colaborador> getColaboradorCollection() {
        return colaboradorCollection;
    }

    public void setColaboradorCollection(Collection<Colaborador> colaboradorCollection) {
        this.colaboradorCollection = colaboradorCollection;
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
        hash += (idinforme != null ? idinforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.idinforme == null && other.idinforme != null) || (this.idinforme != null && !this.idinforme.equals(other.idinforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Informe[ idinforme=" + idinforme + " ]";
    }
    
}
