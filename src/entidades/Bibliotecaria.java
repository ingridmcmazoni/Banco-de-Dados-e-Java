package entidades;

public class Bibliotecaria {
	private int codBibliotecaria;
	private String nome;
	private Bibliotecaria codSupervisor;
	
	
	
	public Bibliotecaria() {
		super();
		this.codBibliotecaria = 0;
		this.nome = "";
		this.codSupervisor = null;
	}
	public int getCodBibliotecaria() {
		return codBibliotecaria;
	}
	public void setCodBibliotecaria(int codBibliotecaria) {
		this.codBibliotecaria = codBibliotecaria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Bibliotecaria getCodSupervisor() {
		return codSupervisor;
	}
	public void setCodSupervisor(Bibliotecaria codSupervisor) {
		this.codSupervisor = codSupervisor;
	}
	
	

}
