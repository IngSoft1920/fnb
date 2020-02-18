package ingsoft1920.fnb.Beans;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//Este bean se va a mantener en sesion hasta que el cliente cierre todas las pestañas del navegador de la web
@SessionScope
@Component
public class EjemploContadorBean {
	private int contadorVisitas=0;
	private List<String> listaHoras=new ArrayList<String>();
	
	public EjemploContadorBean() {}
	
	public int getContadorVisitas() {
		return this.contadorVisitas;
	}
	
	public void setContadorVisitas(int contadorInicial) {
		this.contadorVisitas=contadorInicial;
	}
	
	public void addOne() {
		this.contadorVisitas++;
		this.listaHoras.add(new Date().toString());
		 
	}
	
	public List<String> getListaHoras(){
		return this.listaHoras;
	}
	
	public void setListaHoras(List<String> listaHoras) {
		this.listaHoras=listaHoras;
	}
}
