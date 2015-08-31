/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.funcionalidad;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Funcionalidad;

/**
 *
 * @author root
 */
@Stateless
public class funcionalidadFacade extends abstractFacade<Funcionalidad>{
    
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public funcionalidadFacade() {
        super(Funcionalidad.class);
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }

}
