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
		//Kullan�c�dan ald��� de�erlerle birlikte field� waterla doldurur. 
	}
	public void printField() {
		//Field� g�sterir.
	}
	public void updateField() {
		//At��la beraber de�i�en field� g�nceller.
	}
	public void shipCoordinates() {
		//Playerdan gemileri yerle�tirmek i�in koordinat ve pozisyon bilgisi al�r.
	}
	public void placeShips() {
		//shipCoordinates() metoduyla gelen koordinatlara gemileri yerle�tirir.
	}
	public void getCoordinatesToShoot() {
		//Kullan�c�dan kar�� tarafa at�� yapaca�� koordinat�n girilmesini ister.
	}
	public void checkShips() {
		//Oyunda shotShipCells'i kontrol eder.E�er bir taraf�n t�m shipleri vurulmu�sa kazanan taraf� ilan eder
		
	}
	public void printInformation() {
		//shotCells �zerinden vurulan h�creleri, hamle say�s�n� ve vurulan gemi say�s�n� s�yler.
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
