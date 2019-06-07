package Palavra;

public class Palavra {
	private String dica1;
	private String dica2;
	private String dica3;
	private String palavra;
	private boolean utilizada;
	
	public Palavra(String palavra, String dica1, String dica2, String dica3){
		this.palavra = palavra;
		this.dica1 = dica1;
		this.dica2 = dica2;
		this.dica3 = dica3;
		this.utilizada = false;
	}
	
	public String GetPalavra() {
		return palavra;
	}
	
	public String GetDica1() {
		return dica1;
	}
	
	public String GetDica2() {
		return dica2;
	}
	
	public String GetDica3() {
		return dica3;
	}
	
	public boolean JaFoiUtilizada() {
		return utilizada;
	}
}