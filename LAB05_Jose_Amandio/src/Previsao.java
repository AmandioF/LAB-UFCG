/**
* Representa��o de uma previsão.
*
* @author Jos� Amandio Ferreira dos Santos
*/
public enum Previsao {
	
	VAI_ACONTECER("VAI ACONTECER"),
	NAO_VAI_ACONTECER("N VAI ACONTECER");
	
	private String descricao;
	
	/** 
	 * cria uma previs�o com umas das 2 descri��es possiveis
	 * "VAI ACONTECER" ou "N VAI ACONTECER"
	 * 
	 * @param descricao uma das 2 possiveis previs�es
	 */
	private Previsao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * retorna a descri��o da previs�o
	 * 
	 * @return descri��o
	 */
	public String getPrevisao() {
		return this.descricao;
	}
}
