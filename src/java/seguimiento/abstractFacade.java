/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author JULIAN
 */
public abstract class abstractFacade<T> {
    private Class<T> entityClass;
    
    public abstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEM();
    
    public void crear(T entity) {
        getEM().persist(entity);
    }
    
    public T crearR(T entity){
        return getEM().merge(entity);
         
    }

    public void editar(T entity) {
        getEM().merge(entity);
    }

    public void eliminar(T entity) {
        getEM().remove(getEM().merge(entity));
    }

    public T find(Object id) {
        return getEM().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEM().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEM().createQuery(cq).getResultList();
    }
}
