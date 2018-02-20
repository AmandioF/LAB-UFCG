import java.util.*;

/**
* Representa��o de um cen�rio.
*
* @author Jos� Amandio Ferreira dos Santos
*/
public class Cenario implements Comparable<Cenario> {
	private int soma;
	private int numAposta;
	private int indice;
	
	private String cenario;
	private Status status;
	
	 
	/**
    * Constroe um Cenario.
    * Todo cenario recebe uma descri��o.
    * 
    * @param descricao descri��o do cenario
    * 
    */
	public Cenario(String descricao, int indice) {
		 
		if(descricao == null) {
			throw new NullPointerException();
		}
		if(descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia"); 
		}
		this.cenario = descricao;
		this.status = Status.NAO_FINALIZADO;
		this.soma = 0;
		this.indice = indice;
		this.numAposta = 0;
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
	 * retorna o numero de aposta do cenario
	 * 
	 * @return numero de apostas
	 */
	public int getNumAposta() {
		return this.numAposta;
	}
	
	/**
	 * retorna o indice do cenario
	 * 
	 * @return indice do cenario
	 */
	public int getIndice() {
		return this.indice;
	}
	
	/**
	 * retorna a descrição do cenario
	 * 
	 * @return descrição do cenario
	 */
	public String getCenario() {
		return this.cenario;
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
	 * @param ocorreu determina se o cenario ocorreu ou n�o
	 */
	public void setStatus(boolean ocorreu) {
		if(ocorreu) {
			this.status = Status.FINALIZADO_OCORREU;
		}else this.status = Status.FINALIZADO_NAO_OCORREU;
	}
	
	/**
	 * retorna a representação em String de um cenario
	 */
	@Override
	public String toString() {
		return this.cenario + " - " + this.status.getDescricao();
	}

	/**
	 * incrementa um no contador de numero de aposta
	 */
	public void upNumAposta() {
		this.numAposta++;
	}

	/**
	 * compara dois cenarios a partir do indice
	 */
	@Override
	public int compareTo(Cenario outraConta) {
		if (this.indice < outraConta.indice) {
            return -1;
        }
        if (this.indice > outraConta.indice) {
            return 1;
        }
        return 0;
	}
	
	

}
