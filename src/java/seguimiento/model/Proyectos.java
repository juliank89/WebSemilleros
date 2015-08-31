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
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByIdproyecto", query = "SELECT p FROM Proyectos p WHERE p.idproyecto = :idproyecto"),
    @NamedQuery(name = "Proyectos.findByNombreproyexto", query = "SELECT p FROM Proyectos p WHERE p.nombreproyexto = :nombreproyexto"),
    @NamedQuery(name = "Proyectos.findByEstado", query = "SELECT p FROM Proyectos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proyectos.findByResumen", query = "SELECT p FROM Proyectos p WHERE p.resumen = :resumen")})
public class Proyectos implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "objetivogeneral")
    private String objetivogeneral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private Collection<ObjetivosProyecto> objetivosProyectoCollection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "metodologia")
    private String metodologia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "planteamiento")
    private String planteamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "marco_teorico")
    private String marcoTeorico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "justificacion")
    private String justificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "introduccion")
    private String introduccion;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproyecto")
    private Integer idproyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreproyexto")
    private String nombreproyexto;
    @Size(max = 500)
    @Column(name = "resumen")
    private String resumen;
    @JoinColumn(name = "idsemillero", referencedColumnName = "idsemilleros")
    @ManyToOne(optional = false)
    private Semilleros idsemillero;
    @JoinColumn(name = "idlinea", referencedColumnName = "idlinea")
    @ManyToOne(optional = false)
    private Lineainvestigacion idlinea;
    

    public Proyectos() {
    }

    public Proyectos(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Proyectos(Integer idproyecto, String nombreproyexto, boolean estado) {
        this.idproyecto = idproyecto;
        this.nombreproyexto = nombreproyexto;
        this.estado = estado;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombreproyexto() {
        return nombreproyexto;
    }

    public void setNombreproyexto(String nombreproyexto) {
        this.nombreproyexto = nombreproyexto;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Semilleros getIdsemillero() {
        return idsemillero;
    }

    public void setIdsemillero(Semilleros idsemillero) {
        this.idsemillero = idsemillero;
    }

    public Lineainvestigacion getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Lineainvestigacion idlinea) {
        this.idlinea = idlinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproyecto != null ? idproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.idproyecto == null && other.idproyecto != null) || (this.idproyecto != null && !this.idproyecto.equals(other.idproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seguimiento.model.Proyectos[ idproyecto=" + idproyecto + " ]";
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getPlanteamiento() {
        return planteamiento;
    }

    public void setPlanteamiento(String planteamiento) {
        this.planteamiento = planteamiento;
    }

    public String getMarcoTeorico() {
        return marcoTeorico;
    }

    public void setMarcoTeorico(String marcoTeorico) {
        this.marcoTeorico = marcoTeorico;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @XmlTransient
    public Collection<ObjetivosProyecto> getObjetivosProyectoCollection() {
        return objetivosProyectoCollection;
    }

    public void setObjetivosProyectoCollection(Collection<ObjetivosProyecto> objetivosProyectoCollection) {
        this.objetivosProyectoCollection = objetivosProyectoCollection;
    }

    public String getObjetivogeneral() {
        return objetivogeneral;
    }

    public void setObjetivogeneral(String objetivogeneral) {
        this.objetivogeneral = objetivogeneral;
    }
}
