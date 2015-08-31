/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.tipoproducto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Tipoproducto;

/**
 *
 * @author root
 */
@Stateless
public class tipoProductoFacade extends abstractFacade<Tipoproducto>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;
    
    public tipoProductoFacade() {
        super(Tipoproducto.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
