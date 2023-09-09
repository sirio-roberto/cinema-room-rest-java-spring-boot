package cinema.business;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {
    @JsonProperty("row")
    private final int ROW;

    @JsonProperty("column")
    private final int COLUMN;

    public Seat(int row, int column) {
        this.ROW = row;
        this.COLUMN = column;
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COLUMN;
    }
}
