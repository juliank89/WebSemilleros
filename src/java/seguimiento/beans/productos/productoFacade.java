/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.productos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Productos;

/**
 *
 * @author root
 */
@Stateless
public class productoFacade extends abstractFacade<Productos> {

    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public productoFacade() {
        super(Productos.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
