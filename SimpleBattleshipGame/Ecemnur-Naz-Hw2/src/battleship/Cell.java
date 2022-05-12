package battleship;

//Oyunun, sonradan gemi b�l�m� veya su olabilecek, vurulabilen en k���k par�as�.
public abstract class Cell {
	
	private char cellType='*';//vurulmadan �nce defaultu '*', vurulduktan sonra denizse 'O',gemiyse 'X'.
	private int width;//Her bir h�crenin geni�li�i
	private int lenght;//Her bir h�crenin uzunlu�u
	private boolean isHit;//H�crenin vurulup vurulmad���n� s�yler

	public abstract void changeCellType();
	
	public void resetCellType() {
		//H�creyi default '*' haline d�nd�r�r.
	}
	
	public char getCellType() {
		return cellType;
	}

	public void setCellType(char cellType) {
		this.cellType = cellType;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

}