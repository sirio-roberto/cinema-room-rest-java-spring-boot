package cinema.business.dto;

import cinema.business.Seat;

public class SeatDTO {
    private int row;
    private int column;

    public SeatDTO() {
    }

    public SeatDTO(int row, int column) {
        this.row = row;
        this.column = column;
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

    public static SeatDTO convertSeatToDTO(Seat seat) {
        return new SeatDTO(seat.getRow(), seat.getColumn());
    }

    public static Seat convertDTOtoSeat(SeatDTO dto) {
        // will set the default price to 8
        return new Seat(dto.getRow(), dto.getColumn(), 8);
    }
}
