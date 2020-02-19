package ingsoft1920.fnb.Beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoginBean {
	Map<String, String> users;
	boolean habilitated;

	public LoginBean(Map<String, String> users, boolean habilitated) {
		super();
		this.users = users;
		this.habilitated = habilitated;
	}

	@Override
	public String toString() {
		return "LoginBean [users=" + users + ", habilitated=" + habilitated + "]";
	}

	public Map<String, String> getUsers() {
		return users;
	}

	public void setUsers(Map<String, String> users) {
		this.users = users;
	}

	public boolean getHabilitated() {
		return habilitated;
	}

	public void setHabilitated(boolean habilitated) {
		this.habilitated = habilitated;
	}

	public LoginBean() {
		users=new HashMap<String, String>();
		users.put("paco", "1234");// cocina
		users.put("afesio", "1234");// camarero
		users.put("pepe", "pepe");// metre
		habilitated=false;

	}

}
