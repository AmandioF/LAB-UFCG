import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaTest {
	private Sistema sistema;

	//Testes de Index
	
	@Test(expected=IllegalArgumentException.class)
	public void testcadastrarCenarioBonusZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou", 0);
		
	}
	
	public void testcadastrarCenarioBonusNegativa() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou", -10);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExibirCenarioInexistentePositivo() {
		sistema = new Sistema(10, 0.01);
		sistema.exibirCenario(1);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExibirCenarioInexistenteNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Oliveira vai ganhar a SBC");
		sistema.exibirCenario(-1);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExibirCenarioInvalidoZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou");
		sistema.exibirCenario(0);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaInexistentePositivoVerdadeiro() {
		sistema = new Sistema(10, 0.01);
		sistema.fecharAposta(1, true);;
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaInexistenteNegativoVerdadeiro() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Oliveira vai ganhar a SBC");
		sistema.fecharAposta(-1, true);;
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaInexistenteZeroVerdadeiro() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Oliveira vai ganhar a SBC");
		sistema.fecharAposta(0, true);;
		
	}
	 
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaInexistentePositivoFalso() {
		sistema = new Sistema(10, 0.01);
		sistema.fecharAposta(1, false);;
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaInexistenteNegativoFalso() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Oliveira vai ganhar a SBC");
		sistema.fecharAposta(-1, false);;
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaInexistenteZeroFalso() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Oliveira vai ganhar a SBC");
		sistema.fecharAposta(0, false);;
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaCenarioInexistenteNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarAposta(-1, "Klebinho", 10, "VAI ACONTECER");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaCenarioInexistentePositivo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarAposta(15, "Klebinho", 10, "VAI ACONTECER");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaCenarioInexistenteZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarAposta(0, "Klebinho", 10, "VAI ACONTECER");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarAposta(1, "Klebinho", -10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarAposta(1, "Klebinho", 0, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorCenarioInexistenteNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(-1, "Klebinho", 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorCenarioInexistentePositivo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(15, "Klebinho", 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorCenarioInexistenteZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(0, "Klebinho", 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorValorNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", -10, "VAI ACONTECER", 10, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorValorZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", 0, "VAI ACONTECER", 10, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorSeguroZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", 10, "VAI ACONTECER", 0, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorSeguroNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", 10, "VAI ACONTECER", -10, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorCustoNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", 10, "VAI ACONTECER", 10, -20);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaCenarioInexistenteNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(-1, "Klebinho", 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaCenarioInexistentePositivo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(15, "Klebinho", 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaCenarioInexistenteZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(0, "Klebinho", 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaValorNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(1, "Klebinho", -10, "VAI ACONTECER", 10, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaValorZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(1, "Klebinho", 0, "VAI ACONTECER", 10, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaSeguroZero() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(1, "Klebinho", 10, "VAI ACONTECER", 0, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaSeguroNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(1, "Klebinho", 10, "VAI ACONTECER", -10, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaCustoNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarApostaSeguraTaxa(1, "Klebinho", 10, "VAI ACONTECER", 10, -20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarSeguroValorCenarioNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarSeguroValor(-1, 1, 20);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarSeguroValorCenarioZero() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarSeguroValor(0, 1, 20);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarSeguroValorAsseguradaNegativa() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarSeguroValor(1, -1, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarSeguroValorAsseguradaZero() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarSeguroValor(1, 0, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarSeguroValorValorNegativa() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarSeguroValor(1, -1, -20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarSeguroValorValorZero() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarSeguroValor(1, 1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorTotalDeApostasIndexNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.valorTotalDeApostas(-10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorTotalDeApostasIndexZero() {
		sistema = new Sistema(10, 0.01);
		sistema.valorTotalDeApostas(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorTotalDeApostasIndexInexistente() {
		sistema = new Sistema(10, 0.01);
		sistema.valorTotalDeApostas(10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalDeApostasIndexNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.totalDeApostas(-10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalDeApostasIndexZero() {
		sistema = new Sistema(10, 0.01);
		sistema.totalDeApostas(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalDeApostasIndexInexistente() {
		sistema = new Sistema(10, 0.01);
		sistema.totalDeApostas(10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioIndexInexistente() {
		sistema = new Sistema(10, 0.01);
		sistema.getCaixaCenario(10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioIndexNegativo() {
		sistema = new Sistema(10, 0.01);
		sistema.getCaixaCenario(-10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioIndexZero() {
		sistema = new Sistema(10, 0.01);
		sistema.getCaixaCenario(0);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testexibirCenarioOrdenadoZero() {
		sistema = new Sistema(10, 0.01);
		sistema.exibirCenarioOrdenado(0);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testexibirCenarioOrdenadoNegativa() {
		sistema = new Sistema(10, 0.01);
		sistema.exibirCenarioOrdenado(-10);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testexibirCenarioOrdenadoPositivo() {
		sistema = new Sistema(10, 0.01);
		sistema.exibirCenarioOrdenado(1);
		
	}
	//Testes com valor nulo
	@Test(expected=NullPointerException.class)
	public void testCadastrarCenarioNull() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarCenarioBonusNull() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario(null, 10);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastraApostaApostadorNulo() {
		sistema = new Sistema(10,  0.01);
		sistema.cadastrarCenario("O preço do açucar vai diminuir");
		sistema.cadastrarAposta(1, null, 10, "VAI ACONTECER");
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastraApostaApostaNula() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O preço do açucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, null);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaSeguraValorNulo() {
		sistema = new Sistema(10,  0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarApostaSeguraValor(1, null, 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaSeguraValorApostaNula() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", 10, null, 10 , 20);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaSeguraTaxaNulo() {
		sistema = new Sistema(10,  0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarApostaSeguraTaxa(1, null, 10, "VAI ACONTECER", 10, 20);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaSeguraTaxaApostaNula() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarApostaSeguraTaxa(1, "Klebinho", 10, null, 10 , 20);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarOrdemNull() {
		sistema = new Sistema(10, 0.01);
		sistema.alterarOrdem(null);
	}
	
	//Teste valor vazio
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("      ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioBonusVazio() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("      ", 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaApostadorVazio() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O preço do açucar vai diminuir");
		sistema.cadastrarAposta(1, "     ", 10, "VAI ACONTECER");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaApostaVazio() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "        ");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarOrdemVazio() {
		sistema = new Sistema(10, 0.1);
		sistema.alterarOrdem("        ");
	}
	
	
	//Testes de validade
	
	@Test
	public void testCadastraCenario() {
		sistema = new Sistema(10, 0.01);
		assertEquals("Indice de cadastro incorreto",1 ,sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir"));
		
	}
	
	@Test
	public void testExibirCenarios1() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n" ,sistema.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios2() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n" ,sistema.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios3() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		sistema.cadastrarCenario("Amandio vai reprovar Calculo 2 e Discreta");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n"
									  + "3 - Amandio vai reprovar Calculo 2 e Discreta - Nao finalizado\n" ,sistema.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios4() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		sistema.cadastrarCenario("Amandio vai reprovar Calculo 2 e Discreta", 1500);
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n"
									  + "3 - Amandio vai reprovar Calculo 2 e Discreta - Nao finalizado - R$ 15,00\n" ,sistema.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenario() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado" ,sistema.exibirCenario(1));
		
	}
	
	@Test
	public void testExibirCenarioBonus() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir", 10000);
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado - R$ 100,00" ,sistema.exibirCenario(1));
		
	}
	
	@Test 
	public void testCadastraAposta() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "VAI ACONTECER");
	}
	
	@Test 
	public void testCadastrarApostaSeguraValor() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarApostaSeguraValor(1, "Klebinho", 10, "VAI ACONTECER", 10, 20);
	}
	
	@Test 
	public void testValorTotalDeApostas() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O preço do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Zezinho", 26, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("Valor Errado", 136, sistema.valorTotalDeApostas(1));
	}
	
	@Test 
	public void testTotalDeApostas() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O preço do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Zezinho", 26, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("Valor Errado", 3, sistema.totalDeApostas(1));
	}
	
	@Test 
	public void testExibeApostas1() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "VAI ACONTECER");
		assertEquals("String incorreta", "- Klebinho - R$ 0,10 - VAI ACONTECER\n", sistema.exibeApostas(1));
	}
	
	@Test 
	public void testExibeApostas2() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O preço do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("String incorreta", "- Klebinho - R$ 0,10 - VAI ACONTECER\n"
									   + "- Alandeghvdson - R$ 1,00 - VAI ACONTECER\n", sistema.exibeApostas(1));
	}
	
	@Test 
	public void testExibeApostas3() {
		sistema = new Sistema(10, 0.1);
		sistema.cadastrarCenario("O pre�o do a�ucar vai diminuir");
		sistema.cadastrarAposta(1, "Klebinho", 10, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Zezinho", 26, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Alandeghvdson", 100, "VAI ACONTECER");
		assertEquals("String incorreta", "- Klebinho - R$ 0,10 - VAI ACONTECER\n"
									   + "- Zezinho - R$ 0,26 - VAI ACONTECER\n"
									   + "- Alandeghvdson - R$ 1,00 - VAI ACONTECER\n", sistema.exibeApostas(1));
	}
	
	@Test
	public void testGetCaixaCenarioValidoFullwinnersTrue() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou comprar coxinha");
		sistema.cadastrarAposta(1, "Olivier", 150, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Pigjohson", 350, "VAI ACONTECER");
		sistema.fecharAposta(1, true);
		assertEquals("valor do caixa incorreto", 0,sistema.getCaixaCenario(1));
	}
	
	@Test
	public void testGetCaixaCenarioValidoFullwinnersFalse() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou comprar coxinha");
		sistema.cadastrarAposta(1, "Olivier", 150, "N VAI ACONTECER");
		sistema.cadastrarAposta(1, "Pigjohson", 350, "N VAI ACONTECER");
		sistema.fecharAposta(1, false);
		assertEquals("valor do caixa incorreto", 0,sistema.getCaixaCenario(1));
	}
	
	@Test
	public void testGetCaixaCenarioValidoFullLosersTrue() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou comprar coxinha");
		sistema.cadastrarAposta(1, "Olivier", 150, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Pigjohson", 350, "VAI ACONTECER");
		sistema.fecharAposta(1, false);
		assertEquals("valor do caixa incorreto", 5,sistema.getCaixaCenario(1));
	}
	
	@Test
	public void testGetCaixaCenarioValidoFullLosersFalse() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou comprar coxinha");
		sistema.cadastrarAposta(1, "Olivier", 150, "N VAI ACONTECER");
		sistema.cadastrarAposta(1, "Pigjohson", 350, "N VAI ACONTECER");
		sistema.fecharAposta(1, true);
		assertEquals("valor do caixa incorreto", 5,sistema.getCaixaCenario(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioInvalido() {
		sistema = new Sistema(10, 0.01);
		sistema.cadastrarCenario("Eu vou comprar coxinha");
		sistema.cadastrarAposta(1, "Olivier", 150, "N VAI ACONTECER");
		sistema.cadastrarAposta(1, "Pigjohson", 350, "N VAI ACONTECER");
		sistema.getCaixaCenario(1);
	}

}
