package ingsoft1920.fnb.Model;

public class ElemComandaM {
	private int elemComanda_id;
	private int n_elem;

	public ElemComandaM(int elemComanda_id, int n_elem) {
		super();
		this.elemComanda_id = elemComanda_id;
		this.n_elem = n_elem;
	}

	
	public ElemComandaM(int elemComanda_id) {
		super();
		this.elemComanda_id = elemComanda_id;
	}

	public int getElemComanda_id() {
		return elemComanda_id;
	}

	public void setElemComanda_id(int elemComanda_id) {
		this.elemComanda_id = elemComanda_id;
	}

	public int getN_elem() {
		return n_elem;
	}

	public void setN_elem(int n_elem) {
		this.n_elem = n_elem;
	}
}
