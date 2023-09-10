package cinema.business;

import java.util.UUID;

public class PurchasedTicket {
    private UUID token;
    private Seat ticket;

    public PurchasedTicket() {
    }

    public PurchasedTicket(Seat ticket) {
        this.token = UUID.randomUUID();
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
