/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.areatematica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Areatematica;

/**
 *
 * @author root
 */
@Stateless
public class areaTematicaFacade extends abstractFacade<Areatematica>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public areaTematicaFacade() {
        super(Areatematica.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
