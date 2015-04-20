package entidades;

public class Editora {
	private int codEditora;
	private String nome;
	private String cnpj;
	private String razaoSocial;
	
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Editora() {
		super();
		this.codEditora = 0;
		this.nome = "";
		this.cnpj="";
		this.razaoSocial="";
	}
	public int getCodEditora() {
		return codEditora;
	}
	public void setCodEditora(int codEditora) {
		this.codEditora = codEditora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
