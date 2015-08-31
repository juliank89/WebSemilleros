/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.beans.productos;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import seguimiento.model.Productos;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class CrearProducto implements Serializable{

    private Productos producto;
    private String asdd;
    public CrearProducto() {
    }

    /**
     * @return the producto
     */
    public Productos getProducto() {
        if(producto==null){
            producto= new Productos();
        }
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    public void asd(){
        System.out.println(asdd);
    }

    /**
     * @return the asd
     */
    public String getAsdd() {
        return asdd;
    }

    /**
     * @param asdd the asd to set
     */
    public void setAsdd(String asdd) {
        this.asdd = asdd;
    }
    
    
}
