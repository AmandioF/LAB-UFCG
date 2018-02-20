import java.util.Comparator;

public class ApostaComparator implements Comparator<Cenario>{
	
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
