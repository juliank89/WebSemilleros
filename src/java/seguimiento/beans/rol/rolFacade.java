/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.rol;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Rol;

/**
 *
 * @author root
 */
@Stateless
public class rolFacade extends abstractFacade<Rol>{
    
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public rolFacade() {
        super(Rol.class);
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }

}