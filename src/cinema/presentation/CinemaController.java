package cinema.presentation;

import cinema.business.Cinema;
import cinema.business.CinemaService;
import cinema.business.PurchasedTicket;
import cinema.business.Seat;
import cinema.business.dto.SeatDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("api/v1")
public class CinemaController {
    private final CinemaService service;

    public CinemaController(CinemaService service) {
        this.service = service;
    }

    @GetMapping("seats")
    public ResponseEntity<Cinema> getSeats() {
        return ResponseEntity.ok()
                .body(service.getCinema());
    }

    @PostMapping("purchase")
    public ResponseEntity<Object> purchaseTicket(@RequestBody SeatDTO dto) {
        try {
            PurchasedTicket ticket = service.purchaseTicket(dto);
            if (ticket == null) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "The ticket has been already purchased!"));
            }
            return ResponseEntity.ok()
                    .body(ticket);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    @PostMapping("return")
    public ResponseEntity<Object> returnTicket(@RequestBody Map<String, String> token) {
        Seat returnedSeat = service.returnTicket(token);
        if (returnedSeat == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Wrong token!"));
        }
        return ResponseEntity.ok()
                .body(Map.of("returned_ticket", returnedSeat));
    }

    @GetMapping("stats")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Object> getStats(@RequestParam(required = false) String password) {
        if ("super_secret".equals(password)) {
            return ResponseEntity.ok(service.getStats());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "The password is wrong!"));
    }
}
