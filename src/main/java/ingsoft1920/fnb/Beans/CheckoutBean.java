package ingsoft1920.fnb.Beans;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.Model.ComandaM;


@Component
@SessionScope
public class CheckoutBean {
	java.util.List<ComandaM> listaComandasListas;
	
	public CheckoutBean() {
		listaComandasListas= ComandaDAO.comandasCompletadasCocina(3);
	}

	public java.util.List<ComandaM> getListaComandasListas() {
		return listaComandasListas;
	}

	public void setListaComandasListas(java.util.List<ComandaM> listaComandasListas) {
		this.listaComandasListas = listaComandasListas;
	}
	
	
	
	

}
