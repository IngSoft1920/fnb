package ingsoft1920.fnb.Model;

import java.time.LocalDateTime;

public class Mesa_ubicacionM {
	private MesaM mesa;
	private UbicacionM ubicacion;
	private LocalDateTime fecha_reserva;

	public Mesa_ubicacionM(LocalDateTime fecha_reserva) {
		super();
		this.fecha_reserva = fecha_reserva;
	}
	public Mesa_ubicacionM(MesaM mesa, UbicacionM ubicacion, LocalDateTime fecha_reserva) {
		super();
		this.mesa = mesa;
		this.ubicacion = ubicacion;
		this.fecha_reserva = fecha_reserva;
	}
	public MesaM getMesa() {
		return mesa;
	}
	public void setMesa(MesaM mesa) {
		this.mesa = mesa;
	}
	public UbicacionM getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(UbicacionM ubicacion) {
		this.ubicacion = ubicacion;
	}
	public LocalDateTime getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(LocalDateTime fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

}
