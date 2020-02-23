package ingsoft1920.fnb.Beans;

import org.springframework.stereotype.Component;

@Component
public class TareaEmpleadoBean {
	
	public TareaEmpleadoBean(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	private int id_incidencia;

	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}
	
}
