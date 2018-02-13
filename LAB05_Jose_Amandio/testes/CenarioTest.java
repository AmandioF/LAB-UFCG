import static org.junit.Assert.*;

import org.junit.Test;

public class CenarioTest {
	
	
	// Teste de valores nulo
	@Test(expected=NullPointerException.class)
	public void testCeanrioNulo() {
		Cenario cenario = new Cenario(null);
	}
	
	
	// Teste de valores vazios
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioVazio() {
		Cenario cenario = new Cenario("        ");
	}

}
