/**
* Representação das apostas.
*
* @author José Amandio Ferreira dos Santos
*/
public class Aposta {
	private String apostador;
	private  int valor;
	protected Previsao aposta;
	
	/**
    * ConstrÃ³i uma Aposta.
    * Toda Aposta recebe um parametro de Apostador, valor e aposta.
    * 
    * @param apostador pessoas que esta fazendo a aposta
    * @param valor valor da aposta feita pelo apostador 
    * @param aposta tipo de aposta feita pelo apostador
    *  
    */
	public Aposta(String apostador, int valor, String aposta) {
		this.apostador =apostador;
		this.valor = valor;
		
		if(aposta.equals("N VAI ACONTECER")) this.aposta = Previsao.NAO_VAI_ACONTECER;
		else this.aposta = Previsao.VAI_ACONTECER;
		
	}
	

	/**
    * retorna o valor da aposta feita pelo apostador.
    * 
    * @return valor da aposta
    * 
	*/
	public int getValor() {
		return this.valor;
	}
	
	
	/**
    * retorna a previsão que foi feita pela aposta.
    * 
    * @return previsao da aposta
    * 
	*/
	public Status getPrevisao() {
		if(this.aposta.equals(Previsao.NAO_VAI_ACONTECER)) return Status.FINALIZADO_NAO_OCORREU;
		return Status.FINALIZADO_OCORREU;
	}
	
	
	@Override
	public String toString() {
		return String.format("- %s - R$ %.2f - %s",this.apostador, this.valor/100., this.aposta.getPrevisao());
	}
}
