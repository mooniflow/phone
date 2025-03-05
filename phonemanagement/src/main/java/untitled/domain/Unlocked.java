package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Unlocked extends AbstractEvent {

    private Long id;
    private Long phoneId;
    private Long userId;
    private String lock;

    public Unlocked(Phonemanagement aggregate) {
        super(aggregate);
    }

    public Unlocked() {
        super();
    }
}
//>>> DDD / Domain Event
