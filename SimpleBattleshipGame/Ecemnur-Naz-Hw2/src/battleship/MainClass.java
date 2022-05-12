package battleship;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		
		Player gamer = new Person("Ecem");
		Player pc = new Computer();
		
		Ship ship1 = new Ship(ShipPositions.HORIZONTAL, ShipTypes.DESTROYER, new int[][] {{1,1},{1,2}});
		Ship ship2 = new Ship(ShipPositions.VERTICAL, ShipTypes.BATTLESHIP, new int[][] {{2,3},{3,3},{4,3},{5,3}});
		
		
		ArrayList<Cell> field = new ArrayList<Cell>();
		Cell oneUnit = new Sea();
		field.add(oneUnit);
		field.add(ship2);
		field.add(ship1);
		//...
		
		Battlefield newgame=new Battlefield(new Player[] {gamer,pc}, new Ship[] {ship1,ship2}, field);
	}
}
