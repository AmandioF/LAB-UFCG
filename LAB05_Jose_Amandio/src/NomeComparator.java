import java.util.Comparator;

public class NomeComparator implements Comparator<Cenario> {

	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getCenario().compareTo(cenario2.getCenario());
	}

}
