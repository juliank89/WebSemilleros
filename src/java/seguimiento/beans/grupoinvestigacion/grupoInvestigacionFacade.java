/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.grupoinvestigacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Grupoinvestigacion;

/**
 *
 * @author root
 */
@Stateless
public class grupoInvestigacionFacade extends abstractFacade<Grupoinvestigacion>{

    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public grupoInvestigacionFacade() {
        super(Grupoinvestigacion.class);
    }
    @Override
    protected EntityManager getEM() {
        return em;
    }

    
}
