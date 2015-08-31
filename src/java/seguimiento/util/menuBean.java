/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.util;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.DefaultMenuColumn;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class menuBean {

    private MenuModel model;
    private MenuModel megamodel;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        
        
        DefaultMenuItem item;

        //--------index------------//
        
        item = new DefaultMenuItem("Inicio","ui-icon-home");
        item.setOutcome("/index");

        model.addElement(item);

        //--------perfil-----------//
                
        //-------------Administracion-------------//
        DefaultSubMenu adminSubmenu = new DefaultSubMenu("Administración");
                
        //--------------Usuarios------------------//        
        DefaultSubMenu usuarioSubMenu = new DefaultSubMenu("Usuarios");
        
        item = new DefaultMenuItem("Consultar Usuarios");
        item.setOutcome("/persona/consultarusuarios");
        usuarioSubMenu.addElement(item);

        item = new DefaultMenuItem("Crear Usuarios");
        item.setOutcome("/persona/crearpersona");
        usuarioSubMenu.addElement(item);

        adminSubmenu.addElement(usuarioSubMenu);

        //--------------Red----------------//
        DefaultSubMenu redSubMenu = new DefaultSubMenu("Red");

        item = new DefaultMenuItem("Crear Red");
        item.setOutcome("/red/crearred");
        redSubMenu.addElement(item);

        item = new DefaultMenuItem("Editar Red");
        item.setOutcome("/red/editarred");
        redSubMenu.addElement(item);

        item = new DefaultMenuItem("Consultar Red");
        item.setOutcome("/red/consultarred");
        redSubMenu.addElement(item);

        item = new DefaultMenuItem("Eliminar Red");
        item.setOutcome("/red/eliminarred");
        redSubMenu.addElement(item);

        adminSubmenu.addElement(redSubMenu);

        //--------------Centro-------------//
        DefaultSubMenu centroSubMenu = new DefaultSubMenu("Centros de Investigación");

        item = new DefaultMenuItem("Crear Centro de Investigación");
        item.setOutcome("/centroinvesigacion/crearcentro");
        centroSubMenu.addElement(item);

        item = new DefaultMenuItem("Editar Centro de Investigación");
        item.setOutcome("/centroinvesigacion/editarcentro");
        centroSubMenu.addElement(item);

        item = new DefaultMenuItem("Consultar Centros de Investigación");
        item.setOutcome("/centroinvesigacion/consultarcentro");
        centroSubMenu.addElement(item);

        item = new DefaultMenuItem("Eliminar Centro de Investigación");
        item.setOutcome("/centroinvesigacion/eliminarcentro");
        centroSubMenu.addElement(item);

        adminSubmenu.addElement(centroSubMenu);

        //--------------Grupo--------------//
        DefaultSubMenu grupoSubMenu = new DefaultSubMenu("Grupos de Investigación");

        item = new DefaultMenuItem("Crear Grupo de Investigación");
        item.setOutcome("/grupoinvestigacion/creargrupo");
        grupoSubMenu.addElement(item);

        item = new DefaultMenuItem("Editar Grupo de Investigación");
        item.setOutcome("/grupoinvestigacion/editargrupo");
        grupoSubMenu.addElement(item);

        item = new DefaultMenuItem("Consultar Grupos de Investigación");
        item.setOutcome("/grupoinvestigacion/consultargrupos");
        grupoSubMenu.addElement(item);

        item = new DefaultMenuItem("Eliminar Grupo de Investigación");
        item.setOutcome("/grupoinvestigacion/eliminargrupo");
        grupoSubMenu.addElement(item);

        adminSubmenu.addElement(grupoSubMenu);

        //--------------Linea-------------//
        DefaultSubMenu lineaSubMenu = new DefaultSubMenu("Lineas de Investigación");

        item = new DefaultMenuItem("Crear Linea de Investigación");
        item.setOutcome("/lineainvestigacion/crearlinea");
        lineaSubMenu.addElement(item);

        item = new DefaultMenuItem("Editar Linea de Investigación");
        item.setOutcome("/lineainvestigacion/editarlinea");
        lineaSubMenu.addElement(item);

        item = new DefaultMenuItem("Consultar Linea de Investigación");
        item.setOutcome("/lineainvestigacion/consultarlineas");
        lineaSubMenu.addElement(item);

        item = new DefaultMenuItem("Eliminar Linea de Investigación");
        item.setOutcome("/lineainvestigacion/eliminarlinea");
        lineaSubMenu.addElement(item);

        adminSubmenu.addElement(lineaSubMenu);
        model.addElement(adminSubmenu);

        //-----------Semilleros-----------//
        DefaultSubMenu semilleroSubMenu = new DefaultSubMenu("Semilleros");
       
        item = new DefaultMenuItem("Mis Semilleros");
        item.setOutcome("/semillero/semilleropersona");
        semilleroSubMenu.addElement(item);

        item = new DefaultMenuItem("Consultar Semilleros de Investigación");
        item.setOutcome("/semillero/consultarsemilleros");
        semilleroSubMenu.addElement(item);

        item = new DefaultMenuItem("Crear Semillero de Investigación");
        item.setOutcome("/semillero/crearsemillero");
        semilleroSubMenu.addElement(item);

        item = new DefaultMenuItem("Editar Semillero de Investigación");
        item.setOutcome("/semillero/editarsemilleros");
        semilleroSubMenu.addElement(item);

        item = new DefaultMenuItem("Eliminar Semillero de Investigación");
        item.setOutcome("/semillero/eliminarsemillero");
        semilleroSubMenu.addElement(item);
        
        model.addElement(semilleroSubMenu);

        //--------------Productos-------------//
        
        item = new DefaultMenuItem("Productos");
        item.setOutcome("/productos/productospersona");

        model.addElement(item);
        
//        DefaultSubMenu productoSubMenu = new DefaultSubMenu("Productos");
//
//        item = new DefaultMenuItem("Productos");
//        item.setOutcome("/productos/productospersona");
//        productoSubMenu.addElement(item);
//
//        model.addElement(productoSubMenu);

        //------------Proyectos---------------//
        
        item = new DefaultMenuItem("Proyectos");
        item.setOutcome("/proyectos/proyectospersona");

        model.addElement(item);
        
//        DefaultSubMenu proyectoSubMenu = new DefaultSubMenu("Proyectos");
//
//        item = new DefaultMenuItem("Proyectos");
//        item.setOutcome("/proyectos/proyectospersona");
//        proyectoSubMenu.addElement(item);
//
//        model.addElement(proyectoSubMenu);

        //--------------Informes--------------//
//        DefaultSubMenu informesSubMenu = new DefaultSubMenu("Informes");
//
//        item = new DefaultMenuItem("Informes");
//        item.setOutcome("/informe/crearinforme");
//        informesSubMenu.addElement(item);
//
//        model.addElement(informesSubMenu);
    }

    public MenuModel getModel() {
        return model;
    }
    
    public MenuModel getMegamodel() {
        return megamodel;
    }
}
