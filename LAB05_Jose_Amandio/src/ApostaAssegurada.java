/**
* Representação de uma aposta assegurada.
*
* @author José Amandio Ferreira dos Santos
*/
public class ApostaAssegurada extends Aposta{
	private Tipo seguro;
	
	/**
	 * constroe uma aposta assegurada
	 * 
	 * @param apostador nome do apostador
	 * @param valor valor da aposta
	 * @param aposta previsao feita
	 * @param seguro tipo do seguro
	 */
	public ApostaAssegurada(String apostador, int valor, String aposta, Tipo seguro) {
		super( apostador, valor, aposta);
		this.seguro = seguro;
	}
	
	/**
	 * troca o tipo da aposta podendo ser mantida ou se tornando outro
	 * 
	 * @param seguro novo seguro
	 */
	public void atualizaTipo(Tipo seguro) {
		this.seguro = seguro;
	}
	
	/**
	 * retorna o valor destinado ao saque
	 * 
	 * @return valor/taxa do seguro
	 */
	public int getSaque() {
		return this.seguro.saque();
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.seguro.toString();
	}

}
