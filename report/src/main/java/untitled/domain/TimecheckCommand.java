package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class TimecheckCommand {

    private Long userId;
    private Long phoneId;
    private Date reportDate;
    private Long id;
}
