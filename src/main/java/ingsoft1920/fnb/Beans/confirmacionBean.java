package ingsoft1920.fnb.Beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class confirmacionBean {
	
	 int mesa;
	 int idMesa;
	 int numPersonas;
	 String hab;
	 
	 
	 public confirmacionBean(int mesa, int idMesa, int numPersonas, String hab) {
		super();
		this.mesa = mesa;
		this.idMesa = idMesa;
		this.numPersonas = numPersonas;
		this.hab = hab;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
	@Override
	public String toString() {
		return "confirmacionBean [mesa=" + mesa + ", idMesa=" + idMesa + ", numPersonas=" + numPersonas + ", hab=" + hab
				+ "]";
	}
	public confirmacionBean(){}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public String getHab() {
		return hab;
	}
	public void setHab(String hab) {
		this.hab = hab;
	}
	
	
	

}
