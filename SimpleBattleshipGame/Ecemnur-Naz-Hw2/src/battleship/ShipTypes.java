package battleship;

public enum ShipTypes {
	//Boyutuna göre 5 çeþit gemi var.
	
	CARRIER("Carrier",5),
	BATTLESHIP("Battleship",4),
	SUBMARINE("Submarine",3),
	CRUISER("Cruiser",3),
	DESTROYER("Destroyer",2);
	
	private String name;
	private int size;


	private ShipTypes(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
