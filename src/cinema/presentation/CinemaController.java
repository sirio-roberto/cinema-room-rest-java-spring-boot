package cinema.presentation;

import cinema.business.Cinema;
import cinema.business.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1")
public class CinemaController {
    private final CinemaService service;

    public CinemaController(CinemaService service) {
        this.service = service;
    }

    @GetMapping("seats")
    ResponseEntity<Cinema> getSeats() {
        return ResponseEntity.ok()
                .body(service.getCinema());
    }
}
