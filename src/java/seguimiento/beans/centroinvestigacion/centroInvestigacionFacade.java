/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.centroinvestigacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Centroinvestigacion;

/**
 *
 * @author JULIAN
 */
@Stateless
public class centroInvestigacionFacade extends abstractFacade<Centroinvestigacion> {
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public centroInvestigacionFacade() {
        super(Centroinvestigacion.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
