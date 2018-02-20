import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerCenarioTest {
	private ControllerCenario controle;
	
	//Testes de Index

	
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
	
	
	//Testes com valor nulo
	@Test(expected=NullPointerException.class)
	public void testCadastrarCenarioNull() {
		controle = new ControllerCenario();
		controle.cadastraCenario(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarCenarioBonusNull() {
		controle = new ControllerCenario();
		controle.cadastraCenario(null, 125);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarOrdemNull() {
		controle = new ControllerCenario();
		controle.alterarOrdem(null);
	}
	//Teste valor vazio
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		controle = new ControllerCenario();
		controle.cadastraCenario("      ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioBonusVazio() {
		controle = new ControllerCenario();
		controle.cadastraCenario("      ", 48);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarOrdemVazio() {
		controle = new ControllerCenario();
		controle.alterarOrdem("        ");
	}
	
	//Testes de validade
	
	@Test
	public void testCadastraCenario() {
		controle = new ControllerCenario();
		assertEquals("Indice de cadastro incorreto",1 ,controle.cadastraCenario("O preço do a�ucar vai diminuir"));
		
	}
	
	@Test
	public void testCadastraCenarioBonus() {
		controle = new ControllerCenario();
		assertEquals("Indice de cadastro incorreto",1 ,controle.cadastraCenario("O pre�o do a�ucar vai diminuir", 25));
		
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
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		controle.cadastraCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n" ,controle.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios3() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		controle.cadastraCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		controle.cadastraCenario("Amandio vai reprovar Calculo 2 e Discreta");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n"
									  + "3 - Amandio vai reprovar Calculo 2 e Discreta - Nao finalizado\n" ,controle.exibirCenarios());
		
	}
	
	@Test
	public void testExibirCenarios4() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		controle.cadastraCenario("Amandio vai para o time de Oliveira e Pigmeu em 2018");
		controle.cadastraCenario("Amandio vai reprovar Calculo 2 e Discreta", 1500);
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado\n"
									  + "2 - Amandio vai para o time de Oliveira e Pigmeu em 2018 - Nao finalizado\n"
									  + "3 - Amandio vai reprovar Calculo 2 e Discreta - Nao finalizado - R$ 15,00\n" ,controle.exibirCenarios());
		
	}
	@Test
	public void testExibirCenario() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado" ,controle.exibirCenario(1));
		
	}
	
	@Test
	public void testExibirCenarioBonus() {
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir", 10000);
		assertEquals("String incorreta","1 - O pre�o do a�ucar vai diminuir - Nao finalizado - R$ 100,00" ,controle.exibirCenario(1));
		
	}
	
	@Test
	public void testGetStatus() {
		Status status = Status.NAO_FINALIZADO;
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		assertEquals("Status incorreto",status ,controle.status(1));
		
	}

	@Test
	public void testfechaApostaVerdadeira() {
		Status status = Status.FINALIZADO_OCORREU;
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		controle.fechaAposta(1, true);
		assertEquals("Status incorreto",status ,controle.status(1));
		
	}
	
	
	@Test
	public void testfachaApostaFalsa() {
		Status status = Status.FINALIZADO_NAO_OCORREU;
		controle = new ControllerCenario();
		controle.cadastraCenario("O pre�o do a�ucar vai diminuir");
		controle.fechaAposta(1, false);
		assertEquals("Status incorreto",status ,controle.status(1));
		
	}
	

}
