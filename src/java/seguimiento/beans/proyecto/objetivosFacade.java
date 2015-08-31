/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.proyecto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.ObjetivosProyecto;

/**
 *
 * @author root
 */
@Stateless
public class objetivosFacade extends abstractFacade<ObjetivosProyecto> {
    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public objetivosFacade() {
        super(ObjetivosProyecto.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
