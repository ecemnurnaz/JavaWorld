package battleship;

public class Ship extends Cell implements Sinkable{
	
	private ShipPositions position;//Geminin yatay m� dikey mi oldu�u hakk�nda bilgi verir.
	private ShipTypes type; //5 �e�it gemi var.
	private int[][] location;//Geminin sat�r ve s�tuna g�re konumunu verir. Mesela {{1,1},{1,2}}
	
	@Override
	public void changeCellType() {
		//Vurulan (isHit==true'ysa yani HIT se) h�crenin ,default '*' g�r�n�m�n� gemi b�l�m� i�in 'X' yapar.
		
	}
	
	@Override
	public void sinkShip() {
		//T�m h�creleri vurulmu� geminin sil�etini g�stererek batt���n� belli eder kar�� tarafa.
		
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
