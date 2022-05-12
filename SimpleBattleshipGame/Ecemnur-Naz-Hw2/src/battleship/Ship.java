package battleship;

public class Ship extends Cell implements Sinkable{
	
	private ShipPositions position;//Geminin yatay mý dikey mi olduðu hakkýnda bilgi verir.
	private ShipTypes type; //5 çeþit gemi var.
	private int[][] location;//Geminin satýr ve sütuna göre konumunu verir. Mesela {{1,1},{1,2}}
	
	@Override
	public void changeCellType() {
		//Vurulan (isHit==true'ysa yani HIT se) hücrenin ,default '*' görünümünü gemi bölümü için 'X' yapar.
		
	}
	
	@Override
	public void sinkShip() {
		//Tüm hücreleri vurulmuþ geminin silüetini göstererek battýðýný belli eder karþý tarafa.
		
	}

	
	public Ship(ShipPositions position, ShipTypes type, int[][] location) {
		super();
		this.position = position;
		this.type = type;
		this.location = location;
	}
	
	public ShipPositions getPosition() {
		return position;
	}

	public void setPosition(ShipPositions position) {
		this.position = position;
	}

	public ShipTypes getType() {
		return type;
	}

	

	public void setType(ShipTypes type) {
		this.type = type;
	}

	public int[][] getLocation() {
		return location;
	}

	public void setLocation(int[][] location) {
		this.location = location;
	}

	
	
	
	
	
	
}
