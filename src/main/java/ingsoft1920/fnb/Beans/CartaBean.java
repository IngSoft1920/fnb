package ingsoft1920.fnb.Beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.Model.IngredienteM;
import ingsoft1920.fnb.Model.PlatoIngredienteM;
import ingsoft1920.fnb.Model.PlatoM;

@Component
@SessionScope
public class CartaBean {

    Map<String, PlatoM> platosRest = PlatoDAO.platosRest("Mamma Mia");
    ArrayList<MyEntry<String,List<PlatoIngredienteM>>> carta;
    public CartaBean() {

        carta= new ArrayList<>();
        
        for (Entry<String, PlatoM> plato : platosRest.entrySet()) {
           
            List<PlatoIngredienteM> list = PlatoDAO.ingredientes(plato.getValue().getPlato_id());

            carta.add(new MyEntry<String,List<PlatoIngredienteM>>(plato.getKey(), list));
            
            
        }
        
       
    }

    public ArrayList<MyEntry<String,List<PlatoIngredienteM>>> getPlatosIngre(){

        return carta;

    }


    
}