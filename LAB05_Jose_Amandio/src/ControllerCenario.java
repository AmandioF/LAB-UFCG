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
	 * cadastra um cenario a partir da sua descri��o
	 * 
	 * @param descricao descri��o para cria��o do cenario
	 * 
	 * @return numero do cenario
	 */
	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao, this.cenarios.size());
		this.cenarios.add(cenario);
		return cenarios.size();
	}
	
	/**
	 * cadastra um cenario bonus a partir da sua descri��oo e do seu bonus
	 * 
	 * @param descricao descri��o para cria��o do cenario
	 * @param bonus bonus para em caso de vitoria
	 * 
	 * @return numero do cenario
	 */
	public int cadastraCenario(String descricao, int bonus) {
		if(bonus < 1) throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		CenarioBonus cenario = new CenarioBonus(descricao, this.cenarios.size(), bonus);
		this.cenarios.add(cenario);
		return cenarios.size();
	}

	
	/**
	 * exibe todos o cenarios cadastrados
	 * 
	 * @return representa��o em String com o toString dos cenarios cadastrados
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
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				return cenario + " - " + this.cenarios.get(i).toString();
			}
		}
		return "";
	}
	
	/**
	 * retornar o valor total das apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return valor total das apostas do cenario
	 */
	public int valorTotalDeApostas(int cenario) {
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				return this.cenarios.get(i).getSoma();
			}
		}
		return 0;
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
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				return this.cenarios.get(i).getStatus();
			}
		}
		return Status.NAO_FINALIZADO;
	}
	
	/**
	 * retornará o valor do ultimo cenario criado, ou seja o maior indice
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
	 * @param ocorreu booleano que determinará se o cenario ocorreu ou não
	 */
	public void fechaAposta(int cenario, boolean ocorreu) {
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				this.cenarios.get(i).setStatus(ocorreu);
			}
		}
	}
	
	/**
	 * adiciona o valor de uma nova aposta de um determinado cenario
	 * 
	 * @param cenario cenario com a nova aposta
	 * @param valor valor da nova aposta que ser� adicionado
	 */
	public void upSoma(int cenario, int valor) {
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				this.cenarios.get(i).upSoma(valor);
				break;
			}
		}
	}
	
	/**
	 * retorna o caixa total do cenario
	 * 
	 * @param cenario cenario que ser� analisado
	 * 
	 * @return soma do seu caixa
	 */
	public int getCaixaCenario(int cenario) {
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				return this.cenarios.get(i).getSoma();
			}
		}
		return 0;
	}
	
	/**
	 * retorna o valor a ser direcionado ao rateio do cenario
	 * 
	 * @param cenario cenario que ser� analisado
	 * 
	 * @return soma do valor destinado ao rateio 
	 */
	public int getRateioCenario(int cenario) {
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				return this.cenarios.get(i).getRateio();
			}
		}
		return 0;
	}

	public void upNumAposta(int cenario) {
		for(int i = 0; i < cenarios.size(); i++) {
			if(cenarios.get(i).getIndice() == cenario-1) {
				this.cenarios.get(i).upNumAposta();
				break;
			}
		}
	}
	
	/**
	 * retorna uma string com o toString de um cenario na ordem que foi ordenado
	 * 
	 * @param cenario indice do cenario
	 * @return String do cenario
	 */
	public String exibirCenarioOrdenado(int cenario) {
		if(cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		if(cenario < 1) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		return this.cenarios.get(cenario-1).getIndice()+1 + " - " + this.cenarios.get(cenario-1).toString();
	}
	
	/**
	 * Altera a ordem da lista dos cenarios por nome, numero de apostas e indice
	 *  
	 * @param ordem String indicando qual a ordenação atual da lista
	 */
	public void alterarOrdem(String ordem) {
		if(ordem == null || ordem.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		if(ordem.equals("cadastro")) {
			Collections.sort(cenarios);
		}else if(ordem.equals("nome")) {
			Collections.sort(cenarios, new NomeComparator());
		}else if(ordem.equals("apostas")) {
			Collections.sort(cenarios, new ApostaComparator());
		}else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}
}
