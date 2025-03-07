package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/reports")
@Transactional
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @RequestMapping(
        value = "/reports/report",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Report report(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReportCommand reportCommand
    ) throws Exception {
        System.out.println("##### /report/report  called #####");
        Report report = new Report();
        report.report(reportCommand);
        reportRepository.save(report);
        return report;
    }

    @RequestMapping(
        value = "/reports/{id}/cancelreport",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Report cancelReport(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelReportCommand cancelReportCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /report/cancelReport  called #####");
        Optional<Report> optionalReport = reportRepository.findById(id);

        optionalReport.orElseThrow(() -> new Exception("No Entity Found"));
        Report report = optionalReport.get();
        report.cancelReport(cancelReportCommand);

        reportRepository.delete(report);
        return report;
    }

    @RequestMapping(
        value = "/reports/timecheck",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Report timecheck(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody TimecheckCommand timecheckCommand
    ) throws Exception {
        System.out.println("##### /report/timecheck  called #####");
        Report report = new Report();
        report.timecheck(timecheckCommand);
        reportRepository.save(report);
        return report;
    }
}
//>>> Clean Arch / Inbound Adaptor
