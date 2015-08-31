/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.beans.actividad;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import seguimiento.abstractFacade;
import seguimiento.model.Actividad;

/**
 *
 * @author root
 */
@Stateless
public class actividadFacade extends abstractFacade<Actividad> {

    @PersistenceContext(unitName = "WebSemillerosPU")
    private EntityManager em;

    public actividadFacade() {
        super(Actividad.class);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }

}
