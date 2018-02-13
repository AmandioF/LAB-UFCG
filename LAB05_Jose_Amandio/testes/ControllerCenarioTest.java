import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerCenarioTest {
	private ControllerCenario controle;
	
	//Testes de Index
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testStatusCenarioInexistentePositivo() {
		controle = new ControllerCenario();
		controle.status(1);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testStatusCenarioInexistenteNegativo() {
		controle = new ControllerCenario();
		controle.cadastraCenario("Oliveira vai ganhar a SBC");
		controle.status(-1);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExibirCenarioInexistentePositivo() {
		controle = new ControllerCenario();
		controle.exibirCenario(1);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExibirCenarioInexistenteNegativo() {
		controle = new ControllerCenario();
		controle.cadastraCenario("Oliveira vai ganhar a SBC");
		controle.exibirCenario(-1);
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFecharApostaInexistentePositivoVerdadeiro() {
		controle = new ControllerCenario();
		controle.fechaAposta(1, true);;
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFecharApostaInexistenteNegativoVerdadeiro() {
		controle = new ControllerCenario();
		controle.cadastraCenario("Oliveira vai ganhar a SBC");
		controle.fechaAposta(-1, true);;
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFecharApostaInexistentePositivoFalso() {
		controle = new ControllerCenario();
		controle.fechaAposta(1, false);;
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFecharApostaInexistenteNegativoFalso() {
		controle = new ControllerCenario();
		controle.cadastraCenario("Oliveira vai ganhar a SBC");
		controle.fechaAposta(-1, false);;
		
	}
	
	//Testes com valor nulo
	@Test(expected=NullPointerException.class)
	public void testCadastrarCenarioNull() {
		controle = new ControllerCenario();
		controle.cadastraCenario(null);
	}
	
	//Teste valor vazio
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		controle = new ControllerCenario();
		controle.cadastraCenario("      ");
	}
	
	//Testes de validade
	
	@Test
	public void testCadastraCenario() {
		controle = new ControllerCenario();
		assertEquals("Indice de cadastro incorreto",1 ,controle.cadastraCenario("O preço do açucar vai diminuir"));
		
	}
	
	@Test
	public void testExibirCenarios1() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		assertEquals("String incorreta","1 - O preço do açucar vai diminuir - Nao finalizado\n" ,controle.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios2() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		controle.cadastraCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		assertEquals("String incorreta","1 - O preço do açucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n" ,controle.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios3() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		controle.cadastraCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		controle.cadastraCenario("Amandio vai reprovar Calculo 2 e Discreta");
		assertEquals("String incorreta","1 - O preço do açucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n"
									  + "3 - Amandio vai reprovar Calculo 2 e Discreta - Nao finalizado\n" ,controle.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenario() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		assertEquals("String incorreta","1 - O preço do açucar vai diminuir - Nao finalizado" ,controle.exibirCenario(1));
		
	}
	
	@Test
	public void testGetStatus() {
		Status status = Status.NAO_FINALIZADO;
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		assertEquals("Status incorreto",status ,controle.status(1));
		
	}

	@Test
	public void testfechaApostaVerdadeira() {
		Status status = Status.FINALIZADO_OCORREU;
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		controle.fechaAposta(1, true);
		assertEquals("Status incorreto",status ,controle.status(1));
		
	}
	
	
	@Test
	public void testfachaApostaFalsa() {
		Status status = Status.FINALIZADO_NAO_OCORREU;
		controle = new ControllerCenario();
		controle.cadastraCenario("O preço do açucar vai diminuir");
		controle.fechaAposta(1, false);
		assertEquals("Status incorreto",status ,controle.status(1));
		
	}


}
