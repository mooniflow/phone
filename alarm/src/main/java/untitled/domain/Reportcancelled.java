package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Reportcancelled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long phoneId;
}
