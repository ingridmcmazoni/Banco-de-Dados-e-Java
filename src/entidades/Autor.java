package entidades;

public class Autor {
	private int codAutor;
	private String nome;
	
	
	public Autor() {
		super();
		this.codAutor = 0;
		this.nome = "";
	}
	public int getCodAutor() {
		return codAutor;
	}
	public void setCodAutor(int codAutor) {
		this.codAutor = codAutor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
