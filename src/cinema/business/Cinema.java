package cinema.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Cinema {
    private final int ROWS = 9;
    private final int COLUMNS = 9;
    private final List<Seat> AVAILABLE_SEATS;

    public Cinema() {
        AVAILABLE_SEATS = initAvailableSeats();
    }

    private List<Seat> initAvailableSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int price = i < 4 ? 10 : 8;
                Seat seat = new Seat(i + 1, j + 1, price);
                seats.add(seat);
            }
        }
        return Collections.synchronizedList(seats);
    }

    @JsonProperty("total_rows")
    public int getRows() {
        return ROWS;
    }

    @JsonProperty("total_columns")
    public int getColumns() {
        return COLUMNS;
    }

    @JsonProperty("available_seats")
    public List<Seat> getAvailableSeats() {
        return AVAILABLE_SEATS;
    }
}
