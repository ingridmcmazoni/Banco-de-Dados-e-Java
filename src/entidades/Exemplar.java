package entidades;

public class Exemplar {
	private int codExemplar;
	private Livro livro;
	private Estante estante;
	private Editora editora;
		
	public Exemplar() {
		super();
		this.codExemplar = 0;
		this.livro = null;
		this.estante = null;
		this.editora = null;
	}
	public int getCodExemplar() {
		return codExemplar;
	}
	public void setCodExemplar(int codExemplar) {
		this.codExemplar = codExemplar;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Estante getEstante() {
		return estante;
	}
	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	

}
