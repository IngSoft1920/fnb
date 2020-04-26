package ingsoft1920.fnb.Beans;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class CheckoutBean {
	ArrayList<MyEntry<Integer,Integer>> listaComandasListas;
	
	public CheckoutBean() {
		
		listaComandasListas= new ArrayList<MyEntry<Integer,Integer>>();
		
		
		
	}
	
	
	public void addElement(int mesa,int comandaId) {
		
		listaComandasListas.add(new MyEntry<Integer, Integer>(mesa, comandaId));
		
		
	}


	public ArrayList<MyEntry<Integer, Integer>> getListaComandasListas() {
		return listaComandasListas;
	}


	public void setListaComandasListas(ArrayList<MyEntry<Integer, Integer>> listaComandasListas) {
		this.listaComandasListas = listaComandasListas;
	}
	

}
