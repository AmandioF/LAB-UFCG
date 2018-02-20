/**
* Representa��o de um Tipo Taxa.
*
* @author Jos� Amandio Ferreira dos Santos
*/
public class TipoTaxa implements Tipo{
	private double taxa;
	private double saque;
	
	/**
	 * constroe um tipo taxa a partir da taxa e o valor da aposta
	 * 
	 * @param taxa porcentagem a ser taxada do valor da aposta
	 * @param total valor da aposta
	 */
	public TipoTaxa(double taxa, int total) {
		this.taxa = taxa;
		this.saque = taxa*total;
	}
	
	/**
	 * valor destinado ao saque
	 * 
	 * @return saque
	 */
	@Override
	public int saque() {
		return (int)this.saque;
	}
	@Override
	public String toString() {
		return  String.format("- ASSEGURADA (VALOR) - %.2f%", taxa);
	}

}
