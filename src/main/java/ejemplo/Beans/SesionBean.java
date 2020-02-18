package ingsoft1920.ejemplo.Beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.ejemplo.Model.UsuarioModel;

@Component
//Esta etiqueta permite que el Bean se mantenga en memoria del servidor
//y vaya pasando de clase en clase con la etiqueta @Autowire
@SessionScope 
public class SesionBean {
	int usuarioID;
	public SesionBean(UsuarioModel usuarioModel) {
		this.usuarioID=usuarioModel.getUsuarioID();
	}
	
	public int getUsuarioID() {
		return this.usuarioID;
	}
}
