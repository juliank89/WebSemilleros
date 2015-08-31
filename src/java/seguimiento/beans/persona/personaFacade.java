/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.persona;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Persona;

/**
 *
 * @author root
 */
@Stateless
public class personaFacade extends abstractFacade<Persona>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public personaFacade() {
        super(Persona.class);
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }

    
}
