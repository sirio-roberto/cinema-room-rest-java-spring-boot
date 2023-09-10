package cinema.business;

import cinema.business.dto.SeatDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CinemaService {
    private final Cinema cinema;
    private final List<PurchasedTicket> boughtTickets = Collections.synchronizedList(new ArrayList<>());
    private final Map<String, Integer> stats = new ConcurrentHashMap<>();

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

    public Seat returnTicket(Map<String, String> token) {
        if (token == null || token.get("token") == null) {
            return null;
        }
        UUID tokenValue = UUID.fromString(token.get("token"));
        for (PurchasedTicket ticket : boughtTickets) {
            if (Objects.equals(tokenValue, ticket.getToken())) {
                Seat seat = ticket.getTicket();
                cinema.getAvailableSeats().add(seat);
                boughtTickets.remove(ticket);
                return seat;
            }
        }
        return null;
    }

    public Map<String, Integer> getStats() {
        int currentIncome = boughtTickets.stream()
                .map(PurchasedTicket::getTicket)
                .map(Seat::getPrice)
                .reduce(Integer::sum)
                .orElse(0);

        int availableSeats = getCinema().getAvailableSeats().size();
        int purchasedTickets = boughtTickets.size();

        stats.put("current_income", currentIncome);
        stats.put("number_of_available_seats", availableSeats);
        stats.put("number_of_purchased_tickets", purchasedTickets);
        return stats;
    }
}
