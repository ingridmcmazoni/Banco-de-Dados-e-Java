package entidades;

public class Livro {
	private int codLivro;
	private String titulo;
	private int edicao;
	private int ano;
	
	
	public Livro() {
		super();
		this.codLivro = 0;
		this.titulo = "";
		this.edicao = 0;
		this.ano = 0;
	}
	public int getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	

}
