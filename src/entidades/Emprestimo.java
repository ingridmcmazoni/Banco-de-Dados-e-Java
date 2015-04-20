package entidades;

public class Emprestimo {
	private int codExemplar;
	Cliente c;
	private String dataEmprestimo;
	private String dataDevolucaoPrevista;
	private String dataDevolucaoReal;
	private float valorMulta;
	
	
	

	public Emprestimo() {
		super();
		this.codExemplar = 0;
		this.dataEmprestimo = "";
		this.dataDevolucaoPrevista = "";
		this.dataDevolucaoReal = "";
		this.valorMulta = 0;
	}
	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	public String getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
	public void setDataDevolucaoReal(String dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
	
	public int getCodExemplar() {
		return codExemplar;
	}
	public void setCodExemplar(int codExemplar) {
		this.codExemplar = codExemplar;
	}


	public float getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(float valorMulta) {
		this.valorMulta = valorMulta;
	}
	
	
	
	
	
	
}
