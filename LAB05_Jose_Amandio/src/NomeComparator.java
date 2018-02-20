import java.util.Comparator;

/**
* Comparador por Nome do cenario.
*
* @author José Amandio Ferreira dos Santos
*/
public class NomeComparator implements Comparator<Cenario> {
	
	/**
	 * compara um cenario x com um cenario y a partir do nome de cada um
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getCenario().compareTo(cenario2.getCenario());
	}

}
