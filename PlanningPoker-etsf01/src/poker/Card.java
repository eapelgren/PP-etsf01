package poker;

public class Card implements Card_Interface {
	private int value;
	
	public Card(int value){
		this.value=value;
	}
	
	public Card(String value)
	{
		this.value = Integer.parseInt(value);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		return sb.toString() ;
		
	}
	

}
