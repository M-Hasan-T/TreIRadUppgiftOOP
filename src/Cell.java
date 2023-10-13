/** Model each cell of the game board. */
public class Cell {

    Place cell;
    /** Place of the cell in terms of row and column. */
    int rowOfCell, columnOfCell;

    /** Create the constructor of the cell class */
    public Cell(int rowOfCell, int columnOfCell) {
        this.rowOfCell = rowOfCell;
        this.columnOfCell = columnOfCell;
        this.cell = Place.EMPTY;
    }

    /** Reset the cell to EMPTY */
    public void newGame() {
        this.cell = Place.EMPTY;
    }

    /** Put the symbol to cell */
    public void fillCell() {
        String symbol = this.cell.getSymbol();
        System.out.print(symbol);
    }
}