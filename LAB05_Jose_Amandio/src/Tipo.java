/**
* Representação de um Tipo.
*
* @author José Amandio Ferreira dos Santos
*/
public interface Tipo {
	
	/**
	 *  representação em string de um tipo de seguro
	 *  
	 * @return String do tipo de seguro
	 */
	public abstract String toString();
	
	/**
	 * valor a ser retirado de cada tipo de seguro
	 * 
	 * @return daque de cada seguro
	 */
	public abstract int saque();

}
