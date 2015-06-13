package ssdd;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardSystem {

	private Card bankCard;
	private List<Card> savedBankCards;

	public CardSystem() {
		// TODO - implement CardSystem.CardSystem
		bankCard = new Card();
		savedBankCards = new ArrayList<Card>();
	}

	/**
	 * 
	 * @param card
	 */
	
	public void insertCard(Card card){
		bankCard = card;
	}
	
	public Card getCard(long accountNo){
		for(Card e : savedBankCards){
			if(e.getAccountNo() == accountNo){
				return e;
			}
		}
		return null;
	}

	public Card returnCard() {
		// TODO - implement CardSystem.saveAndReturnCard
		//pretend it's saving
		return bankCard;
	}

	/**
	 * 
	 * @param totalDue
	 */
	public boolean hasEnoughBalance(double totalDue) {
		// TODO - implement CardSystem.hasEnoughBalance
		return (totalDue < bankCard.getBalance());
	}

	/**
	 * 
	 * @param totalDue
	 */
	public void processPayment(double totalDue) {
		// TODO - implement CardSystem.processPayment
		bankCard.setBalance(fixDoubleError(bankCard.getBalance() - totalDue));		
	}

	/**
	 * 
	 * @param accountNo
	 */
	public Card doMagic(long accountNo) {
		// TODO - implement CardSystem.doMagic
		for(Card e : savedBankCards){
			if(e.getAccountNo() == accountNo){
				return e;
			}
		}
		//new card
		double rangeMin = 0.0;
		double rangeMax = 1000.0;
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		randomValue = fixDoubleError(randomValue);
		//no reference
		savedBankCards.add(new Card(accountNo, randomValue));
		return new Card(accountNo, randomValue);
	}
	
	public double fixDoubleError(double value){
		value *= 100;
		value = Math.round(value);
		value /= 100;
		return value;
	}

}