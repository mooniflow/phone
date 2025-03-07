package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.ReportApplication;
import untitled.domain.Insurancecalled;
import untitled.domain.Reportcancelled;
import untitled.domain.Reported;

@Entity
@Table(name = "Report_table")
@Data
//<<< DDD / Aggregate Root
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long phoneId;

    private Date reportDate;


    @PostPersist
    public void onPostPersist() {
        Reported reported = new Reported(this);
        reported.publishAfterCommit();

        Reportcancelled reportcancelled = new Reportcancelled(this);
        reportcancelled.publishAfterCommit();

        Insurancecalled insurancecalled = new Insurancecalled(this);
        insurancecalled.publishAfterCommit();
    }

    public static ReportRepository repository() {
        ReportRepository reportRepository = ReportApplication.applicationContext.getBean(
            ReportRepository.class
        );
        return reportRepository;
    }
}
//>>> DDD / Aggregate Root
