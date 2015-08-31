/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.informe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Informe;

/**
 *
 * @author root
 */
@Stateless
public class informeFacade extends abstractFacade<Informe>{
 @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public informeFacade() {
        super(Informe.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
