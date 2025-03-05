package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Reported extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long phoneId;

    public Reported(Report aggregate) {
        super(aggregate);
    }

    public Reported() {
        super();
    }
}
//>>> DDD / Domain Event
