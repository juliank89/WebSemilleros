/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.resultado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Resultado;

/**
 *
 * @author root
 */
@Stateless
public class resultadoFacade extends abstractFacade<Resultado>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public resultadoFacade() {
        super(Resultado.class);
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }
}
