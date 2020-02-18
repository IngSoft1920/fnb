package ingsoft1920.fnb.Beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.Beans.bebidas;
import ingsoft1920.fnb.Beans.platos;

@Component
@SessionScope
public class TareasBean {

	Map<Integer, Tarea> listaTareas;

	public Map<Integer, Tarea> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(Map<Integer, Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public TareasBean(Map<Integer, Tarea> listaTareas) {
		super();
		this.listaTareas = listaTareas;
	}

	public TareasBean() {

		// query
		List<String> listaPlatos = new ArrayList<String>();
		List<String> listaBebida = new ArrayList<String>();

		listaPlatos.add("lentejas");
		listaPlatos.add("potaje");
		listaBebida.add("Ron Barceló");
		listaBebida.add("almirante");
		Map<String, platos> cantidades = new HashMap<String, platos>();
		Map<String, bebidas> bebidas = new HashMap<String, bebidas>();
		int idComida = 0;
		int idBebida = 0;
		for (int i = 0; i < listaPlatos.size(); i++) {
			cantidades.put(listaPlatos.get(i), new platos(idComida++, 0));
			bebidas.put(listaBebida.get(i), new bebidas(idBebida++, 0));

		}

		listaTareas = new HashMap<Integer, Tarea>();
		listaTareas.put(1, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(2, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(3, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(4, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(5, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(6, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		System.out.println(listaTareas.toString());

	}

	@Override
	public String toString() {
		return "TareasBean [listaTareas=" + listaTareas + "]";
	}

}
