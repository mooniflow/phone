package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReportCommand {

    private Long id;
    private Long phoneId;
    private Date reportDate;
    private Long userId;
}
