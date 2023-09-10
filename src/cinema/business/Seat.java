package cinema.business;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {
    @JsonProperty("row")
    private final int ROW;

    @JsonProperty("column")
    private final int COLUMN;

    @JsonProperty("price")
    private final int PRICE;

    public Seat(int row, int column, int price) {
        this.ROW = row;
        this.COLUMN = column;
        this.PRICE = price;
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COLUMN;
    }

    public int getPrice() {
        return PRICE;
    }
}
