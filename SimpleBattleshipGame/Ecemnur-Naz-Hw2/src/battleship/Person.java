package battleship;

public class Person extends Player{

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void howToPlay() {
		// Ýnsan oyuncunun, nasýl oynayacaðý hakkýnda bilgi verir.
		
	}

}
