package seguimiento.beans.lineainvestigacion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import seguimiento.abstractFacade;
import seguimiento.model.Grupoinvestigacion;
import seguimiento.model.Lineainvestigacion;

/**
 *
 * @author JULIAN
 */
@Stateless
public class LineaInvestigacionFacade extends abstractFacade<Lineainvestigacion>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;
    
    public LineaInvestigacionFacade() {
        super(Lineainvestigacion.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
    
    public  List<Lineainvestigacion> findByGrupo(Grupoinvestigacion idGrupo){
        try {
            Query q = em.createNamedQuery("Lineainvestigacion.findLineaByGrupo")
                    .setParameter("idgrupo", idGrupo);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}