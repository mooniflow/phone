package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class StarttheserviceCommand {

    private Long id;
    private Long phoneId;
    private Long userId;
    private String service;
}
