import java.util.*;

/**
* Representação de Controlado de Cenarios.
*
* @author José Amandio Ferreira dos Santos
*/
public class ControllerCenario {
	private List <Cenario> cenarios;
	private int caixa;
	private double retirada;
	
	/**
    * Constroe um controller de cenario.
    * 
    */
	public ControllerCenario() { 
		this.cenarios = new ArrayList <>();
	}
	
	/**
	 * cadastra um cenario a partir da sua descrição
	 * 
	 * @param descricao descrição para criação do cenario
	 * 
	 * @return numero do cenario
	 */
	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		this.cenarios.add(cenario);
		return cenarios.size();
	}
	
	/**
	 * cadastra um cenario bonus a partir da sua descriçãoo e do seu bonus
	 * 
	 * @param descricao descrição para criação do cenario
	 * @param bonus bonus para em caso de vitoria
	 * 
	 * @return numero do cenario
	 */
	public int cadastraCenario(String descricao, int bonus) {
		if(bonus < 1) throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		CenarioBonus cenario = new CenarioBonus(descricao, bonus);
		this.cenarios.add(cenario);
		return cenarios.size();
	}

	
	/**
	 * exibe todos o cenarios cadastrados
	 * 
	 * @return representação em String com o toString dos cenarios cadastrados
	 */
	public String exibirCenarios() {
		String lista = "";
		for (int cenario = 0; cenario < this.cenarios.size(); cenario++) {
		    lista += cenario+1 + " - " + this.cenarios.get(cenario).toString() + "\n";
		}
		
		return lista;
	}
	
	/**
	 * exibe um unico cenario cadastrado no Sistema
	 * 
	 * @param cenario cenario a ser exibido
	 * 
	 * @return toString do cenario
	 */
	public String exibirCenario(int cenario) {
		if(cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		if(cenario < 1) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario: Cenario invalido");
		}
		return cenario + " - " + this.cenarios.get(cenario-1).toString();
	}
	
	/**
	 * retornar o valor total das apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return valor total das apostas do cenario
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.cenarios.get(cenario-1).getSoma();
	}
	
	
	
	/**
	 * retorna o Status do cenario
	 * 
	 * 
	 * @param cenario cenario a ser analisado
	 * 
	 * @return o Status do cenario
	 */
	public Status status(int cenario) {
		return this.cenarios.get(cenario-1).getStatus();
	}
	
	/**
	 * retornarÃ¡ o valor do ultimo cenario criado, ou seja o maior indice
	 * 
	 * @return o valor do ultimo cenario criado
	 */
	public int getMaxIndice() {
		return this.cenarios.size();
	}
	
	/**
	 * finaliza um cenario como "Finalizado(ocorreu)" ou "Finalizado(n ocorreu)"
	 * 
	 * @param cenario cenario a ser finalizado
	 * 
	 * @param ocorreu booleano que determinarÃ¡ se o cenario ocorreu ou nÃ£o
	 */
	public void fechaAposta(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario-1).setStatus(ocorreu);
	}
	
	/**
	 * adiciona o valor de uma nova aposta de um determinado cenario
	 * 
	 * @param cenario cenario com a nova aposta
	 * @param valor valor da nova aposta que será adicionado
	 */
	public void upSoma(int cenario, int valor) {
		this.cenarios.get(cenario-1).upSoma(valor);
	}
	
	/**
	 * retorna o caixa total do cenario
	 * 
	 * @param cenario cenario que será analisado
	 * 
	 * @return soma do seu caixa
	 */
	public int getCaixaCenario(int cenario) {
		return this.cenarios.get(cenario-1).getSoma();
	}
	
	/**
	 * retorna o valor a ser direcionado ao rateio do cenario
	 * 
	 * @param cenario cenario que será analisado
	 * 
	 * @return soma do valor destinado ao rateio 
	 */
	public int getRateioCenario(int cenario) {
		return this.cenarios.get(cenario-1).getRateio();
	}
	
}
