package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Servicestarted extends AbstractEvent {

    private Long id;
    private Long phoneId;
    private Long userId;
    private String service;

    public Servicestarted(Phonemanagement aggregate) {
        super(aggregate);
    }

    public Servicestarted() {
        super();
    }
}
//>>> DDD / Domain Event
