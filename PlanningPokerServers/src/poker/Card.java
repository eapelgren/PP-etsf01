package poker;

public class Card {
	private int value;
	
	public Card(int value){
		this.value=value;
	}
	
	public Card(String value)
	{
		this.value = Integer.parseInt(value);
	}

	public int getValue() {
		return value;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		return sb.toString() ;
		
	}
	

}
