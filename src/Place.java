
public enum Place {

    CROSS("X"), ZERO("O"), EMPTY(" ");


    // Private variable
    private String symbol;

    // Constructor (must be private)
    private Place(String icon) {
        this.symbol = icon;
    }

    // Public Getter
    public String getSymbol() {
        return symbol;
    }


}
