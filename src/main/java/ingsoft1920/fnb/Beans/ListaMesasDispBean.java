package ingsoft1920.fnb.Beans;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.DAO.ItemDAO;
import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.Model.ItemM;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Services.ConectorBBDD;

@Component
@SessionScope
public class ListaMesasDispBean {
	List<MesaM> listaMesasDisp;
	public ListaMesasDispBean() {
		ConectorBBDD.conectar();
		listaMesasDisp=MesaDAO.mesasDisp();
		ConectorBBDD.desconectar();
	}
	public List<MesaM> getLista() {
		return listaMesasDisp;
	}
}
