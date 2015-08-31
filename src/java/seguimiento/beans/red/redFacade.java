/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.red;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Red;

/**
 *
 * @author root
 */
@Stateless
public class redFacade extends abstractFacade<Red>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;
    
    public redFacade() {
        super(Red.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
