import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerApostaTest {

	private ControllerAposta controle;
	
	//Teste de valores vazios
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaApostadorVazio() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "     ", 10, "VAI ACONTECER");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaApostaVazio() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "        ");
		
	}
	
	//Testes de validade
	
	@Test 
	public void testCadastraAposta() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
	}
	
	@Test 
	public void testValorTotalDeApostas() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("Valor Errado", 136, controle.valorTotalDeApostas(1));
	}
	
	@Test 
	public void testTotalDeApostas() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("Valor Errado", 3, controle.totalDeApostas(1));
	}
	
	@Test 
	public void testExibeApostas1() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		assertEquals("String incorreta", "- Klebinho - R$ 0,10 - VAI ACONTECER\n", controle.exibeApostas(1));
	}
	
	@Test 
	public void testExibeApostas2() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("String incorreta", "- Klebinho - R$ 0,10 - VAI ACONTECER\n"
									   + "- Alandeghvdson - R$ 1,00 - VAI ACONTECER\n", controle.exibeApostas(1));
	}
	
	@Test 
	public void testExibeApostas3() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("String incorreta", "- Klebinho - R$ 0,10 - VAI ACONTECER\n"
									   + "- Zezinho - R$ 0,26 - VAI ACONTECER\n"
									   + "- Alandeghvdson - R$ 1,00 - VAI ACONTECER\n", controle.exibeApostas(1));
	}
	
	@Test 
	public void testGetCaixaCenarioTrue() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("String incorreta", 136 , controle.getCaixaCenario(1 , Previsao.VAI_ACONTECER));
	}
	
	@Test 
	public void testGetCaixaCenarioFalse() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "N VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "N VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "N VAI ACONTECER");
		assertEquals("String incorreta", 136 , controle.getCaixaCenario(1 , Previsao.NAO_VAI_ACONTECER));
	}
	
	@Test 
	public void testGetCaixaCenarioVariadoFalse() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "N VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "N VAI ACONTECER");
		assertEquals("String incorreta", 126 , controle.getCaixaCenario(1 , Previsao.NAO_VAI_ACONTECER));
	}
	
	@Test 
	public void testGetCaixaCenarioVariadoTrue() {
		controle = new ControllerAposta();
		controle.cadastraAposta(1, "Klebinho", 10, "VAI ACONTECER");
		controle.cadastraAposta(1, "Zezinho", 26, "N VAI ACONTECER");
		controle.cadastraAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("String incorreta", 110 , controle.getCaixaCenario(1 , Previsao.VAI_ACONTECER));
	}
}
