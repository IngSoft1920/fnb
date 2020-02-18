package ingsoft1920.ejemplo.Beans;

import org.springframework.stereotype.Component;

//Con la etiqueta component especificamos que esta clase es un Bean 
@Component
public class SignupBean {
	String usuario;
	String password;
	String email;
	int idEstudiante;
	
	//En un bean siempre es necesario el constructor vacio
	public SignupBean() {}
	
	public boolean checkCamposValidos() {
		return true;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
}
