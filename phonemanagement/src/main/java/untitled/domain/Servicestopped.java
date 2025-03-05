package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Servicestopped extends AbstractEvent {

    private Long id;
    private Long phoneId;
    private Long userId;
    private String service;

    public Servicestopped(Phonemanagement aggregate) {
        super(aggregate);
    }

    public Servicestopped() {
        super();
    }
}
//>>> DDD / Domain Event
