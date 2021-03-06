package ingsoft1920.fnb.Model;

import java.time.LocalDateTime;

public class ComandaM {
	
	@Override
	public String toString() {
		return "ComandaM [comanda_id=" + comanda_id + ", estado_acabado=" + estado_acabado + ", ubicacion=" + ubicacion
				+ ", tarea_cocinera=" + tarea_cocinera + ", hora=" + hora + ", plato=" + plato + "]";
	}
	private int comanda_id;
	private Boolean estado_acabado;
	private UbicacionM ubicacion;
	private int tarea_cocinera;
	private LocalDateTime hora;
	private PlatoM plato;
	private MesaM mesa;
	
	
	public ComandaM(int comanda_id, LocalDateTime hora,MesaM mesa) {
		super();
		this.comanda_id = comanda_id;
		this.hora = hora;
		this.mesa = mesa;
	}
	public ComandaM(int comanda_id, Boolean estado_acabado, UbicacionM ubicacion, int tarea_cocinera,
			LocalDateTime hora) {
		super();
		this.comanda_id = comanda_id;
		this.estado_acabado = estado_acabado;
		this.ubicacion = ubicacion;
		this.tarea_cocinera = tarea_cocinera;
		this.hora = hora;
	}
	public ComandaM(int comanda_id, LocalDateTime hora, PlatoM plato) {
		this.comanda_id = comanda_id;
		this.hora = hora;
		this.plato = plato;
	}
	
	public MesaM getMesa() {
		return mesa;
	}
	public void setMesa(MesaM mesa) {
		this.mesa = mesa;
	}
	
	public ComandaM(int comanda_id) {
		this.comanda_id=comanda_id;
	}
	public int getComanda_id() {
		return comanda_id;
	}
	public void setComanda_id(int comanda_id) {
		this.comanda_id = comanda_id;
	}
	public Boolean getEstado_acabado() {
		return estado_acabado;
	}
	public void setEstado_acabado(Boolean estado_acabado) {
		this.estado_acabado = estado_acabado;
	}
	public UbicacionM getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(UbicacionM ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getTarea_cocinera() {
		return tarea_cocinera;
	}
	public void setTarea_cocinera(int tarea_cocinera) {
		this.tarea_cocinera = tarea_cocinera;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}
	public PlatoM getPlato() {
		return plato;
	}
	public void setPlato(PlatoM plato) {
		this.plato = plato;
	}
	
}
