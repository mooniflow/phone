package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Insurancecalled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long phoneId;
    private Date reportDate;

    public Insurancecalled(Report aggregate) {
        super(aggregate);
    }

    public Insurancecalled() {
        super();
    }
}
//>>> DDD / Domain Event
