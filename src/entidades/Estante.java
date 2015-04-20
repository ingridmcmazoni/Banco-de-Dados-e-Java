package entidades;

public class Estante {
	private int codEstante;
	private String corredor;
	private String prateleira;
	
	Bibliotecaria b;
		

	public Estante() {
		super();
		this.codEstante = 0	;
		this.corredor="";
		this.prateleira="";
	}

	public String getCorredor() {
		return corredor;
	}

	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	public Bibliotecaria getB() {
		return b;
	}

	public void setB(Bibliotecaria b) {
		this.b = b;
	}

	public int getCodEstante() {
		return codEstante;
	}

	public void setCodEstante(int codEstante) {
		this.codEstante = codEstante;
	}
	
	
	

}
