/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.contacto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Contacto;

/**
 *
 * @author root
 */
@Stateless
public class contactoFacade extends abstractFacade<Contacto> {
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public contactoFacade() {
        super(Contacto.class);
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }
}
