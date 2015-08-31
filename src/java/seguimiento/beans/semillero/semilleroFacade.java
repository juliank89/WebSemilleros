/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.semillero;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Semilleros;

/**
 *
 * @author root
 */
@Stateless
public class semilleroFacade extends abstractFacade<Semilleros>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public semilleroFacade() {
        super(Semilleros.class);
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }
}
