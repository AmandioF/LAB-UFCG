/**
* Representa��o de um cen�rio com bonus.
*
* @author Jos� Amandio Ferreira dos Santos
*/
public class CenarioBonus extends Cenario{
	private int bonus;
	
	/**
    * Constroe um Cenario com bonus.
    * Todo cenario recebe uma descri��o e bonus.
    * 
    * @param descricao descri��o do cenario
    * @param bonus bonus a ser adicionado ao rateio do cenario
    * 
    */
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		this.bonus = bonus;
	}
	
	/**
	 * retorna o valor destinado ao rateio
	 * 
	 * @return o valor da soma junto com o bonus
	 */
	@Override
	public int getRateio() {
		return super.getSoma() + this.bonus;
	}
	
	@Override
	public String toString() {
		return String.format("%s - R$ %.2f", super.toString(), this.bonus/100.);
	}
}
