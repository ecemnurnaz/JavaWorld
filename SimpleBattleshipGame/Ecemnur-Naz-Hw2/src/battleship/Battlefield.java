package battleship;

import java.util.ArrayList;

public class Battlefield {

	private Player[] players;
	private Ship[] ships;
	private ArrayList<Cell> field;
	private ArrayList<Ship> shotShipCells;
	private int row;
	private int column;

	public Battlefield(Player[] players, Ship[] ships, ArrayList<Cell> field) {
		super();
		this.players = players;
		this.ships = ships;
		this.field = field;
	}
	public void makeField() {
		//Kullanýcýdan aldýðý deðerlerle birlikte fieldý waterla doldurur. 
	}
	public void printField() {
		//Fieldý gösterir.
	}
	public void updateField() {
		//Atýþla beraber deðiþen fieldý günceller.
	}
	public void shipCoordinates() {
		//Playerdan gemileri yerleþtirmek için koordinat ve pozisyon bilgisi alýr.
	}
	public void placeShips() {
		//shipCoordinates() metoduyla gelen koordinatlara gemileri yerleþtirir.
	}
	public void getCoordinatesToShoot() {
		//Kullanýcýdan karþý tarafa atýþ yapacaðý koordinatýn girilmesini ister.
	}
	public void checkShips() {
		//Oyunda shotShipCells'i kontrol eder.Eðer bir tarafýn tüm shipleri vurulmuþsa kazanan tarafý ilan eder
		
	}
	public void printInformation() {
		//shotCells üzerinden vurulan hücreleri, hamle sayýsýný ve vurulan gemi sayýsýný söyler.
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public Ship[] getShips() {
		return ships;
	}
	public void setShips(Ship[] ships) {
		this.ships = ships;
	}
	public ArrayList<Cell> getField() {
		return field;
	}
	public void setField(ArrayList<Cell> field) {
		this.field = field;
	}
	public ArrayList<Ship> getShotShipCells() {
		return shotShipCells;
	}
	public void setShotShipCells(ArrayList<Ship> shotShipCells) {
		this.shotShipCells = shotShipCells;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
	
	
}
