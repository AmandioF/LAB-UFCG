import static org.junit.Assert.*;

import org.junit.Test;

public class ApostaTest {
	
	
	// testes de valor nulo
	@Test(expected=NullPointerException.class)
	public void testApostadorNull() {
		Aposta aposta = new Aposta( null, 150,"VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaNull() {
		Aposta aposta = new Aposta( "clebis", 150,null);
	}
	
	//testes de valor vazio
	@Test(expected=IllegalArgumentException.class)
	public void testApostadorVazio() {
		Aposta aposta = new Aposta( "       ", 150,"VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaVazia() {
		Aposta aposta = new Aposta( "joandir", 150,"             ");
	}
	
	//testes de index
	@Test(expected=IllegalArgumentException.class)
	public void testValorNegativo() {
		Aposta aposta = new Aposta("yuri", -150,"VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorZero() {
		Aposta aposta = new Aposta( "yuri", 0,"VAI ACONTECER");
	}

}
