package battleship;

//Oyunun, sonradan gemi bölümü veya su olabilecek, vurulabilen en küçük parçasý.
public abstract class Cell {
	
	private char cellType='*';//vurulmadan önce defaultu '*', vurulduktan sonra denizse 'O',gemiyse 'X'.
	private int width;//Her bir hücrenin geniþliði
	private int lenght;//Her bir hücrenin uzunluðu
	private boolean isHit;//Hücrenin vurulup vurulmadýðýný söyler

	public abstract void changeCellType();
	
	public void resetCellType() {
		//Hücreyi default '*' haline döndürür.
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