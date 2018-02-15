import java.util.*;

/**
 * Representação de um Controlador de Apostas
 * 
 * @author José Amandio Ferreira dos Santos
 *
 */
public class ControllerAposta { 
	private Map<Integer, ArrayList<Aposta> > apostas;
	private Map<Integer, ArrayList<ApostaAssegurada>> asseguradas;
	
	/**
	 * Constroe um controller de Apostas
	 */
	public ControllerAposta() {
		this.apostas = new HashMap<>();
		this.asseguradas = new HashMap<>();
	}
	
	/**
    * Cadastra uma aposta.
    * Toda Aposta recebe um parametro de cenario, Apostador, valor e previsao.
    * 
    * @param cenario indice do cenario que foi feita a aposta
    * @param apostador pessoas que esta fazendo a aposta
    * @param valor valor da aposta feita pelo apostador
    * @param previsao tipo de aposta feita pelo apostador
    * 
    */
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		this.validar(cenario, apostador,  valor,  previsao,"Erro no cadastro de aposta:" );
		Aposta aposta = new Aposta(apostador, valor, previsao);
		if(!apostas.containsKey(cenario-1)) apostas.put(cenario-1,  new ArrayList<>());
		if(!asseguradas.containsKey(cenario-1)) asseguradas.put(cenario-1,  new ArrayList<>());
		apostas.get(cenario-1).add(aposta);
	}
	
	/**
    * Cadastra uma aposta assegurada por valor.
    * Toda Aposta assegurada por valor recebe um parametro de cenario, Apostador, valor, previsao e seguro.
    * 
    * @param cenario indice do cenario que foi feita a aposta
    * @param apostador pessoas que esta fazendo a aposta
    * @param valor valor da aposta feita pelo apostador
    * @param previsao tipo de aposta feita pelo apostador
    * @param seguro valor assegurado em caso de derrota
    * 
    */
    public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int seguro) {
    	this.validar(cenario, apostador,  valor,  previsao,"Erro no cadastro de aposta assegurada por valor:" );
    	Tipo seguroValor = new TipoValor(seguro);
    	ApostaAssegurada aposta = new ApostaAssegurada( apostador, valor, previsao, seguroValor);
    	
    	if(!apostas.containsKey(cenario-1)) apostas.put(cenario-1,  new ArrayList<>());
		apostas.get(cenario-1).add(aposta);
		
		if(!asseguradas.containsKey(cenario-1)) asseguradas.put(cenario-1,  new ArrayList<>());
		asseguradas.get(cenario-1).add(aposta);
		
		return asseguradas.get(cenario-1).size();
    }
    
    /**
     * Cadastra uma aposta assegurada por valor.
     * Toda Aposta assegurada por taxa recebe um parametro de cenario, Apostador, valor, previsao e seguro.
     * 
     * @param cenario indice do cenario que foi feita a aposta
     * @param apostador pessoas que esta fazendo a aposta
     * @param valor valor da aposta feita pelo apostador
     * @param previsao tipo de aposta feita pelo apostador
     * @param seguro valor assegurado em caso de derrota
     * 
     */
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double seguro) {
    	this.validar(cenario, apostador,  valor,  previsao,"Erro no cadastro de aposta assegurada por taxa:" );
    	Tipo seguroTaxa = new TipoTaxa(seguro, valor);
    	ApostaAssegurada aposta = new ApostaAssegurada( apostador, valor, previsao,seguroTaxa);
    	
    	if(!apostas.containsKey(cenario-1)) apostas.put(cenario-1,  new ArrayList<>());
    	apostas.get(cenario-1).add(aposta);
    	if(!asseguradas.containsKey(cenario-1)) asseguradas.put(cenario-1,  new ArrayList<>());
		asseguradas.get(cenario-1).add(aposta);
		return asseguradas.get(cenario-1).size();
    }
    
    
    /**
     * analisa os parametros, afim de dizer se estão aptos a serem usados por outros metodos
     * caso não seja, ele retorna um erro ao sistema
     * 
     * @param cenario indice do cenario q a aposta esta localizada
     * @param apostador nome do apostador
     * @param valor valor da aposta
     * @param aposta previsao feita pela aposta
     * @param mensagem mensagem a ser enviada no throw new exception
     */
    private void validar(int cenario, String apostador, int valor, String aposta, String mensagem) {
    	
		if(apostador == null) {
			throw new NullPointerException(mensagem + " Apostador nao pode ser vazio ou nulo");
		}if(apostador.trim().equals("")) {
			throw new IllegalArgumentException(mensagem + " Apostador nao pode ser vazio ou nulo");
		}
		
		if(valor <= 0) {
			throw new IllegalArgumentException(mensagem + " Valor nao pode ser menor ou igual a zero");
		}
		
		if(aposta == null) {
			throw new NullPointerException(mensagem + " Previsao nao pode ser vazia ou nula");
		}if(aposta.trim().equals("")) {
			throw new IllegalArgumentException(mensagem + " Previsao nao pode ser vazia ou nula");
		}
		if(!aposta.equals("N VAI ACONTECER") && !aposta.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException(mensagem + " Previsao invalida");
		}
		if(cenario <= 0) throw new IllegalArgumentException(mensagem + " Cenario invalido");
	}
    
    /**
     * Altera uma aposta assegurada tornando-a uma aposta de valor
     * 
     * @param cenario cenario em que a aposta assegurada esta localizada
     * @param apostaAssegurada id da aposta assegurada
     * @param valor novo valor da aposta
     */
    public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
    	Tipo novo = new TipoValor(valor);
    	this.asseguradas.get(cenario-1).get(apostaAssegurada-1).atualizaTipo(novo);
    }
    
    /**
     * Altera uma aposta assegurada tornando-a uma aposta do tipo taxa
     * 
     * @param cenario cenario em que a aposta assegurada esta localizada
     * @param apostaAssegurada id da aposta assegurada
     * @param valor nova taxa da aposta
     */
    public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
    	Tipo novo = new TipoTaxa(taxa, asseguradas.get(cenario-1).get(apostaAssegurada-1).getValor());
    	this.asseguradas.get(cenario-1).get(apostaAssegurada-1).atualizaTipo(novo);
    }
    
	
	/**
	 * retorna o numero de apostas feitas num cenario x
	 * 
	 * @param cenario cenario x
	 * 
	 * @return numero de apostas feitas no cenario
	 */
	public int totalDeApostas(int cenario) {
		return this.apostas.get(cenario-1).size();	
	}
	
	/**
	 * retorna a representaÃ§Ã£o em string com todas as apostas de um determinado cenario
	 * 
	 * @param cenario cenario que serÃ¡ pritando as apostas
	 * 
	 * @return as apostas feitas no cenario
	 */
	public String exibeApostas(int cenario) {
		String lista = "";
		for(int aposta = 0; aposta < this.apostas.get(cenario-1).size(); aposta++) {
			lista += this.apostas.get(cenario-1).get(aposta).toString() + "\n";
		}
		
		return lista;
	}
	
	/**
	 * retorna a soma dos valores dos vencedores de determinado cenario
	 * 
	 * @param cenario indice do cenario fechado
	 * @param status resultado do cenario
	 * 
	 * @return a soma dos valores de todas as aposta que venceram
	 */
	public int getVencedores(int cenario, Status status) {
		int soma = 0;
		for(int apostas = 0; apostas < this.apostas.get(cenario-1).size(); apostas++) {
			if(this.apostas.get(cenario-1).get(apostas).getPrevisao().equals(status)) {
				soma += this.apostas.get(cenario-1).get(apostas).getValor();
			}
		}
		return soma;
	}
	
	/**
	 * return todas a taxas e valores das apostas asseguradas que perderam
	 * 
	 * @param cenario
	 * @param status
	 * 
	 * @return a soma dos seguros das apostas que perderam
	 */
	public int pagaSeguro(int cenario, Status status) {
		int soma = 0;
		for(int aposta = 0; aposta < this.asseguradas.get(cenario-1).size(); aposta++) {
			if(!this.asseguradas.get(cenario-1).get(aposta).getPrevisao().equals(status)) {
				 soma += this.asseguradas.get(cenario-1).get(aposta).getSaque();
			}
		}
		return soma;
	} 
	
}
