package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Reported extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long phoneId;
}
