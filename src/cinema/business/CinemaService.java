package cinema.business;

import cinema.business.dto.SeatDTO;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    private final Cinema cinema;

    public CinemaService(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Seat purchaseTicket(SeatDTO dto) {
        if (dto.getRow() < 1
                || dto.getRow() > cinema.getRows()
                || dto.getColumn() < 1
                || dto.getColumn() > cinema.getColumns()) {
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
        for (Seat seat : cinema.getAvailableSeats()) {
            if (dto.getRow() == seat.getRow() && dto.getColumn() == seat.getColumn()) {
                cinema.getAvailableSeats().remove(seat);
                return seat;
            }
        }
        return null;
    }
}
