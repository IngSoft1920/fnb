package ingsoft1920.fnb.Beans;


import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaReservasBean {
	ArrayList<reservas>listareservas;
	public ListaReservasBean() {
		listareservas=new ArrayList<reservas>();
		listareservas.add(new reservas(LocalDate.now().toString(),4,"Julian"));
		listareservas.add(new reservas(LocalDate.now().toString(),8,"Peter"));
		listareservas.add(new reservas(LocalDate.now().toString(),8,"Cloe"));
		
	}
	
}
