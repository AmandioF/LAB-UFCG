import java.util.Comparator;

/**
* Comparador por numero de Apostas do cenario.
*
* @author José Amandio Ferreira dos Santos
*/
public class ApostaComparator implements Comparator<Cenario>{
	
	/**
	 * compara um cenario x com um cenario y a partir do numero de apostas de cada um
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		if (cenario1.getNumAposta() > cenario2.getNumAposta()) {
            return -1;
        }
        if (cenario1.getNumAposta() < cenario2.getNumAposta()) {
            return 1;
        }
        return cenario1.compareTo(cenario2);
	}


}
