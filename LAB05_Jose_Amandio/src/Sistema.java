/**
 * RepresentaÃ§Ã£o de um Sistema
 * 
 * @author José Amandio Ferreira dos Santos
 *
 */
public class Sistema {
	private int caixa;
	private double taxa;
	
	private ControllerCenario controleCenarios;
	private ControllerAposta controleApostas;
	
	/**
	 * cria um sistema
	 * o sistema receber dois parametros caixa e porcentagem
	 * 
	 * @param caixa caixa inicial do sistema
	 * @param taxa porcentagem de lucro do sistema com as apostas
	 */
	public Sistema(int caixa, double taxa) {
		
		this.controleApostas = new ControllerAposta();
		this.controleCenarios = new ControllerCenario();
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	/**
     * analisa os parametros, afim de dizer se estão aptos a serem usados por outros metodos
     * caso não seja, ele retorna um erro ao sistema
     * 
     * @param mensagem retornada no throw new exception
     * @param cenario indice do cenario q a aposta esta localizada
     */
	private void validar(String mensagem, int cenario) {
		if(cenario < 1) {
			throw new IllegalArgumentException(mensagem +  " Cenario invalido");
		}
		if(cenario > this.controleCenarios.getMaxIndice()) {
			throw new IllegalArgumentException(mensagem + " Cenario nao cadastrado");
		}
	}
	/**
	 * retorna o caixa do Sistema
	 * 
	 * @return valor presente no caixa
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * cadastra um cenario a partir da sua descrição
	 * 
	 * @param descricao descrição para criação do cenario
	 * 
	 * @return numero do cenario
	 */
	public int cadastrarCenario(String descricao){
		return this.controleCenarios.cadastraCenario(descricao);
	}
	
	/**
	 * cadastra um cenario bonus a partir da sua descrição e bonus
	 * 
	 * @param descricao descrição para criação do cenario bonus
	 * @param bonus bonus presente no cenario
	 * 
	 * @return numero do cenario
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		this.caixa -= bonus;
		return this.controleCenarios.cadastraCenario(descricao, bonus);
	}

	/**
	 * exibe um unico cenario cadastrado no Sistema
	 * 
	 * @param cenario cenario a ser exibido
	 * 
	 * @return toString do cenario
	 */
	public String exibirCenario(int cenario) {
		return this.controleCenarios.exibirCenario(cenario);
	}

	/**
	 * exibe todos o cenarios cadastrados
	 * 
	 * @return representação em String com o toString dos cenarios cadastrados
	 */
	public String exibirCenarios() {
		return this.controleCenarios.exibirCenarios();
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
		this.validar("Erro no cadastro de aposta:", cenario);
		
		this.controleApostas.cadastraAposta(cenario, apostador, valor, previsao);
		this.controleCenarios.upSoma(cenario, valor);
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
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int seguro, int custo) {
		this.validar("Erro no cadastro de aposta assegurada por valor:", cenario);
		this.caixa += custo;
		this.controleCenarios.upSoma(cenario, valor);
    	return this.controleApostas.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, seguro);
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
    * @return ID da aposta
    * 
    */
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double seguro, int custo) {
    	this.validar("Erro no cadastro de aposta assegurada por taxa:", cenario);
    	this.caixa += custo;
    	this.controleCenarios.upSoma(cenario, valor);
    	return this.controleApostas.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, seguro);
    }
    
    /**
     * Altera uma aposta assegurada tornando-a uma aposta de valor
     * 
     * @param cenario cenario em que a aposta assegurada esta localizada
     * @param apostaAssegurada id da aposta assegurada
     * @param valor novo valor da aposta
     */
    public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
    	this.controleApostas.alterarSeguroValor(cenario, apostaAssegurada, valor);
    }
    
    /**
     * Altera uma aposta assegurada tornando-a uma aposta do tipo taxa
     * 
     * @param cenario cenario em que a aposta assegurada esta localizada
     * @param apostaAssegurada id da aposta assegurada
     * @param taxa nova taxa da aposta
     */
    public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
    	this.controleApostas.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
    }
    
	/**
	 * retornar o valor total das apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return valor total das apostas do cenario
	 */
	public int valorTotalDeApostas(int cenario) {
		this.validar("Erro na consulta do valor total de apostas:", cenario);
		
		return this.controleCenarios.valorTotalDeApostas(cenario);
	}
	
	/**
	 * retorna o numero de apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return numero de apostas feitas no cenario
	 */
	public int totalDeApostas(int cenario) {
		this.validar("Erro na consulta do total de apostas:", cenario);
		return this.controleApostas.totalDeApostas(cenario);
	}
	
	/**
	 * retorna a representação em string com todas as apostas de um determinado cenario
	 * 
	 * @param cenario cenario que será pritando as apostas
	 * 
	 * @return as apostas feitas no cenario
	 */
	public String exibeApostas(int cenario) {
		controleCenarios.exibirCenario(cenario);
		return this.controleApostas.exibeApostas(cenario);
	}
	
	/**
	 * finaliza um cenario como "Finalizado(ocorreu)" ou "Finalizado(n ocorreu)"
	 * 
	 * @param cenario cenario a ser finalizado
	 * 
	 * @param ocorreu booleano que determinará se o cenario ocorreu ou nÃ£o
	 */ 
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.validar("Erro ao fechar aposta:", cenario);
		if(this.controleCenarios.status(cenario) != Status.NAO_FINALIZADO) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		this.controleCenarios.fechaAposta(cenario, ocorreu);
		this.caixa += this.getCaixaCenario(cenario);
		this.caixa -= this.controleApostas.pagaSeguro(cenario,this.controleCenarios.status(cenario));
	}
	
	/**
	 * Retorna o valor total de um cenário encerrado
	 * 
	 * @param cenario canario que terá¡ seu valor exibido
	 * 
	 * @return valor total de um valor encerrado
	 */
	public int getCaixaCenario(int cenario) {
		this.validar("Erro na consulta do caixa do cenario:", cenario);
		if( this.controleCenarios.status(cenario).equals(Status.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		int vencedores = this.controleApostas.getVencedores(cenario, this.controleCenarios.status(cenario));
		return (int) Math.floor((this.controleCenarios.getCaixaCenario(cenario)-vencedores)*this.taxa);
	}
	
	/**
	 * Retorna o valor total de um cenário encerrado que será destinado as apostas vencedoras
	 * 
	 * @param cenario cenario que terá o valor distribuido
	 * 
	 * @return valor do valor a ser distribuido entre os vencedores
	 */
	public int getTotalRateioCenario(int cenario) {
		this.validar("Erro na consulta do total de rateio do cenario:", cenario);
		if( this.controleCenarios.status(cenario).equals(Status.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		int vencedores = this.controleApostas.getVencedores(cenario, this.controleCenarios.status(cenario));
		int rateio = this.controleCenarios.getRateioCenario(cenario)-vencedores;
		return rateio - this.getCaixaCenario(cenario);
	}
	
	
}
