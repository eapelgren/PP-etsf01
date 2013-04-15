package poker;
public class CardDeck implements CardDeck_Interface {
	
	public Card[] card;
	private Card chooseCard;
	
	public CardDeck (int size){
		card = new Card[size];
		
		int [] series = new int [size +2];
		series[0]= 0;
		series[1]= 1;
		for( int i= 2; i< series.length; i++){
			series[i]= series[i-1] + series[i-2];
		}
		
		for (int i=0; i<card.length; i++){
			card[i] = new Card(series[i+2]);
		}
	}
	


	@Override
	public Card_Interface chooseCard(int nbr) {
		// TODO Auto-generated method stub
		for(int i=0; i<card.length;i++){
			if(card[i].getValue()== nbr){
				chooseCard = card[i];
				return card[i];
			}
		}
		return null;
	}
	
	public Card_Interface choosenCard(){
		return chooseCard;
	}
	

}
