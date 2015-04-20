package entidades;

public class LivroAutor {
	private Livro livro;
	private Autor autor;
	
	
	public LivroAutor() {
		super();
		this.livro = null;
		this.autor = null;
		
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
	
	

}
