package cinema.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cinema {
    @JsonProperty("total_rows")
    private final int ROWS = 9;

    @JsonProperty("total_columns")
    private final int COLUMNS = 9;

    @JsonProperty("available_seats")
    private final List<Seat> AVAILABLE_SEATS;

    public Cinema() {
        AVAILABLE_SEATS = initAvailableSeats();
    }

    private List<Seat> initAvailableSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Seat seat = new Seat(i + 1, j + 1);
                seats.add(seat);
            }
        }
        return seats;
    }


}
