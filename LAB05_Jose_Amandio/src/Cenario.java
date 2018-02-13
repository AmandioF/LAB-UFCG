import java.util.*;

/**
* Representação de um cenário.
*
* @author José Amandio Ferreira dos Santos
*/
public class Cenario {
	private int soma;
	
	private String cenario;
	private Status status;
	
	 
	/**
    * Constroe um Cenario.
    * Todo cenario recebe uma descrição.
    * 
    * @param descricao descrição do cenario
    * 
    */
	public Cenario(String descricao) {
		 
		if(descricao == null) {
			throw new NullPointerException();
		}
		if(descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia"); 
		}
		this.cenario = descricao;
		this.status = Status.NAO_FINALIZADO;
		this.soma = 0;
	}
	

	/**
	 * retorna a soma dos valores apostados no cenario
	 * 
	 * @return soma das apostas
	 */
	public int getSoma() {
		return this.soma;
	}
	
	/**
	 * retorna o valor de rateio do cenario
	 * 
	 * @return soma das apostas
	 */
	public int getRateio() {
		return this.soma;
	}
	
	/**
	 * retorna o status do cenario
	 * o cenario pode ser "NAO FINALIZADO", "FINALIZADO(OCORREU)" E "FINALIZADO(N OCORREU)"
	 * 
	 * @return status do cenario
	 */
	public Status getStatus() {
		return this.status;
	}
	
	
	/**
	 * adiciona o valor de uma nova aposta cadastrada no cenario a soma
	 * 
	 * @param valor valor da nova aposta
	 */
	public void upSoma(int valor) {
		this.soma += valor;
	}
	
	
	/**
	 *  modifica o status do cenario
	 *  o cenario pode ser modifificado para "FINALIZADO(OCORREU)" ou "FINALIZADO(N OCORREU)" determinado pelo booleano
	 *  
	 * @param ocorreu determina se o cenario ocorreu ou não
	 */
	public void setStatus(boolean ocorreu) {
		if(ocorreu) {
			this.status = Status.FINALIZADO_OCORREU;
		}else this.status = Status.FINALIZADO_NAO_OCORREU;
	}
	
	@Override
	public String toString() {
		return this.cenario + " - " + this.status.getDescricao();
	}

}
