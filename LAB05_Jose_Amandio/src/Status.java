/**
* Representa��o de um Status.
*
* @author Jos� Amandio Ferreira dos Santos
*/
public enum Status {
	
	FINALIZADO_OCORREU("Finalizado (ocorreu)"),
	FINALIZADO_NAO_OCORREU("Finalizado (n ocorreu)"),
	NAO_FINALIZADO("Nao finalizado");

	private String descricao;
	
	/**
	 * cria um Status com umas das 3 descri��es possiveis
	 * "Finalizado(ocorreu)", "Finalizado(n ocorreu)" ou "Nao finalizado"
	 * 
	 * @param descricao um dos 3 possiveis status
	 */
	private Status(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * retorna a descri��o do Status
	 * 
	 * @return descri��o
	 */
	public String getDescricao() {
		return this.descricao;
	}
}
