package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Insurancecharged extends AbstractEvent {

    private Long id;
    private Long phoneId;
    private Long userId;
    private String status;

    public Insurancecharged(Phonemanagement aggregate) {
        super(aggregate);
    }

    public Insurancecharged() {
        super();
    }
}
//>>> DDD / Domain Event
