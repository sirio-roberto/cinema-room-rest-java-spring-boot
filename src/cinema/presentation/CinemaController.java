package cinema.presentation;

import cinema.business.Cinema;
import cinema.business.CinemaService;
import cinema.business.Seat;
import cinema.business.dto.SeatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Objects;

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
            Seat seat = service.purchaseTicket(dto);
            if (seat == null) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "The ticket has been already purchased!"));
            }
            return ResponseEntity.ok()
                    .body(seat);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", ex.getMessage()));
        }
    }
}
