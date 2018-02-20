/**
* Representa��o de um Tipo Taxa.
*
* @author Jos� Amandio Ferreira dos Santos
*/
public class TipoValor implements Tipo{
	private int valor;
	
	/**
	 * constroe um tipo taxa a partir da valor
	 * 
	 * @param valor valor a ser taxado da aposta
	 */
	public TipoValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * valor destinado ao saque
	 * 
	 * @return saque
	 */
	public int saque() {
		return this.valor;
	}
	@Override
	public String toString() {
		return  String.format("- ASSEGURADA (VALOR) - R$%.2f", valor);
	}

}
