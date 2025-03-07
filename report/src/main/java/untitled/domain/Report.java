package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.ReportApplication;

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

    public static ReportRepository repository() {
        ReportRepository reportRepository = ReportApplication.applicationContext.getBean(
            ReportRepository.class
        );
        return reportRepository;
    }

    //<<< Clean Arch / Port Method
    public void report(ReportCommand reportCommand) {
        //implement business logic here:

        Reported reported = new Reported(this);
        reported.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelReport(CancelReportCommand cancelReportCommand) {
        //implement business logic here:

        Reportcancelled reportcancelled = new Reportcancelled(this);
        reportcancelled.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void timecheck(TimecheckCommand timecheckCommand) {
        //implement business logic here:

        Insurancecalled insurancecalled = new Insurancecalled(this);
        insurancecalled.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
