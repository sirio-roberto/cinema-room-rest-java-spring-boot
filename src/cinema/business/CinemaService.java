package cinema.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    private Cinema cinema;

    public Cinema getCinema() {
        return cinema;
    }
}
