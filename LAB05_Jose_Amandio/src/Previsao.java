/**
* Representação de uma previsÃ£o.
*
* @author José Amandio Ferreira dos Santos
*/
public enum Previsao {
	
	VAI_ACONTECER("VAI ACONTECER"),
	NAO_VAI_ACONTECER("N VAI ACONTECER");
	
	private String descricao;
	
	/** 
	 * cria uma previsão com umas das 2 descrições possiveis
	 * "VAI ACONTECER" ou "N VAI ACONTECER"
	 * 
	 * @param descricao uma das 2 possiveis previsões
	 */
	private Previsao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * retorna a descrição da previsão
	 * 
	 * @return descrição
	 */
	public String getPrevisao() {
		return this.descricao;
	}
}
