package ingsoft1920.fnb.Beans;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.DAO.InventarioDAO;
import ingsoft1920.fnb.Model.IngredienteInventarioM;

@Component
@SessionScope
public class InventarioBean {

    List<IngredienteInventarioM>  listaIngredientes;


    public InventarioBean() {
        
       listaIngredientes= InventarioDAO.inventario("Mamma Mia");
    }
   
    public List<IngredienteInventarioM>  getListaInventario(){

        return this.listaIngredientes;
    }



    
}