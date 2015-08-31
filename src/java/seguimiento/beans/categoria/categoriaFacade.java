/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.categoria;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Categoria;

/**
 *
 * @author root
 */
@Stateless
public class categoriaFacade extends abstractFacade<Categoria>{
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public categoriaFacade() {
        super(Categoria.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
