package cinema.business;

import cinema.business.dto.SeatDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CinemaService {
    private final Cinema cinema;
    private List<PurchasedTicket> boughtTickets = Collections.synchronizedList(new ArrayList<>());

    public CinemaService(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public PurchasedTicket purchaseTicket(SeatDTO dto) {
        if (dto.getRow() < 1
                || dto.getRow() > cinema.getRows()
                || dto.getColumn() < 1
                || dto.getColumn() > cinema.getColumns()) {
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
        for (Seat seat : cinema.getAvailableSeats()) {
            if (dto.getRow() == seat.getRow() && dto.getColumn() == seat.getColumn()) {
                PurchasedTicket ticket = new PurchasedTicket(seat);
                boughtTickets.add(ticket);
                cinema.getAvailableSeats().remove(seat);
                return ticket;
            }
        }
        return null;
    }
}
