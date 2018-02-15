import org.junit.runners.model.InitializationError;

import easyaccept.EasyAccept;

/**
* Representação de uma fachada.
*
* @author José Amandio Ferreira dos Santos
*/
public class Facade {
	private static Sistema sistema;
	
	public static void main(String [] args) {
		
		args = new String[] {"Facade", "Lab05_Jose_Amandio/acceptance_test/us1_test.txt","Lab05_Jose_Amandio/acceptance_test/us2_test.txt",
							"Lab05_Jose_Amandio/acceptance_test/us3_test.txt", "Lab05_Jose_Amandio/acceptance_test/us4_test.txt", 
							"Lab05_Jose_Amandio/acceptance_test/us5_test.txt","Lab05_Jose_Amandio/acceptance_test/us6_test.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * inicializa o sistema
	 * 
	 * @param caixa caixa para o sistema
	 * @param taxa porcentagem para o sistema
	 */
	public void inicializa(int caixa, double taxa) {
		if(caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if(taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.sistema = new Sistema(caixa, taxa);
	}
	
	/**
	 * retorna o caixa do Sistema
	 * 
	 * @return valor presente no caixa
	 */
	public int getCaixa() {
		return this.sistema.getCaixa();
	}
	
	/**
	 * cadastra um cenario a partir da sua descriçãoo
	 * 
	 * @param descricao descrição para criação do cenario
	 * 
	 * @return numero do cenario
	 */
	public int cadastrarCenario(String descricao){
		return this.sistema.cadastrarCenario(descricao);
	}
	
	/**
	 * cadastra um cenario bonus a partir da sua descrição e bonus
	 * 
	 * @param descricao descrição para criação do cenario bonus
	 * @param bonus bonus presente no cenario
	 * 
	 * @return numero do cenario
	 */
	public int cadastrarCenario(String descricao, int bonus){
		return this.sistema.cadastrarCenario(descricao, bonus);
	}
	
	/**
	 * exibe um unico cenario cadastrado no Sistema
	 * 
	 * @param cenario cenario a ser exibido
	 * 
	 * @return toString do cenario
	 */
	public String exibirCenario(int cenario) {
		return this.sistema.exibirCenario(cenario);
	}
	
	/**
	 * exibe todos o cenarios cadastrados
	 * 
	 * @return representação em String com o toString dos cenarios cadastrados
	 */
	public String exibirCenarios() {
		return this.sistema.exibirCenarios();
	}
	
	/**
    * Cadastra uma aposta.
    * Toda Aposta recebe um parametro de cenario, Apostador, valor e aposta.
    * 
    * @param cenario indice do cenario que foi feita a aposta
    * @param apostador pessoas que esta fazendo a aposta
    * @param valor valor da aposta feita pelo apostador
    * @param previsao tipo de aposta feita pelo apostador
    * 
    */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	/**
    * Cadastra uma aposta assegurada por valor.
    * Toda Aposta assegurada por valor recebe um parametro de cenario, Apostador, valor, previsao, seguro e custo.
    * 
    * @param cenario indice do cenario que foi feita a aposta
    * @param apostador pessoas que esta fazendo a aposta
    * @param valor valor da aposta feita pelo apostador
    * @param previsao tipo de aposta feita pelo apostador
    * @param seguro valor assegurado em caso de derrota
    * @param custo valor recebido pelo sistema
    * 
    * @return Id da aposta assegurada
    */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int seguro, int custo) {
		return this.sistema.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, seguro, custo);
    }
	
	/**
    * Cadastra uma aposta assegurada por valor.
    * Toda Aposta assegurada por valor recebe um parametro de cenario, Apostador, valor, previsao, seguro e custo.
    * 
    * @param cenario indice do cenario que foi feita a aposta
    * @param apostador pessoas que esta fazendo a aposta
    * @param valor valor da aposta feita pelo apostador
    * @param previsao tipo de aposta feita pelo apostador
    * @param seguro valor assegurado em caso de derrota
    * @param custo valor recebido pelo sistema
    * 
    * @return ID da aposta assegurada
    */
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double seguro, int custo) {
    	return this.sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, seguro, custo);
    }
    
    /**
     * Altera uma aposta assegurada tornando-a uma aposta de valor
     * 
     * @param cenario cenario em que a aposta assegurada esta localizada
     * @param apostaAssegurada id da aposta assegurada
     * @param valor novo valor da aposta
     */
    public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
    	this.sistema.alterarSeguroValor(cenario, apostaAssegurada, valor);
    }
    
    /**
     * Altera uma aposta assegurada tornando-a uma aposta do tipo taxa
     * 
     * @param cenario cenario em que a aposta assegurada esta localizada
     * @param apostaAssegurada id da aposta assegurada
     * @param taxa nova taxa da aposta
     */
    public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
    	this.sistema.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
    }
    
	/**
	 * retornar o valor total das apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return valor total das apostas do cenario
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.sistema.valorTotalDeApostas(cenario);
	}
	
	/**
	 * retorna o numero de apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return numero de apostas feitas no cenario
	 */
	public int totalDeApostas(int cenario) {
		return this.sistema.totalDeApostas(cenario);
	}
	
	/**
	 * retorna a representaÃ§Ã£o em string com todas as apostas de um determinado cenario
	 * 
	 * @param cenario cenario que serÃ¡ pritando as apostas
	 * 
	 * @return as apostas feitas no cenario
	 */
	public String exibeApostas(int cenario) {
		return this.sistema.exibeApostas(cenario);
	}
	
	/**
	 * finaliza um cenario como "Finalizado(ocorreu)" ou "Finalizado(n ocorreu)"
	 * 
	 * @param cenario cenario a ser finalizado
	 * 
	 * @param ocorreu booleano que determinarÃ¡ se o cenario ocorreu ou nÃ£o
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.sistema.fecharAposta(cenario, ocorreu);
	}
	
	/**
	 * Retorna o valor total de um cenário encerrado
	 * 
	 * @param cenario cenario que terá seu valor exibido
	 * 
	 * @return valor total de um valor encerrado
	 */
	public int getCaixaCenario(int cenario) {
		return this.sistema.getCaixaCenario(cenario);
	}
	
	/**
	 * Retorna o valor total de um cenÃ¡rio encerrado que serÃ¡ destinado as apostas vencedoras
	 * 
	 * @param cenario cenario que terÃ¡ o valor distribuido
	 * 
	 * @return valor do valor a ser distribuido entre os vencedores
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.sistema.getTotalRateioCenario(cenario);
	}
	
}
