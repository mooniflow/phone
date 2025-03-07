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
// @RequestMapping(value="/phonemanagements")
@Transactional
public class PhonemanagementController {

    @Autowired
    PhonemanagementRepository phonemanagementRepository;

    @RequestMapping(
        value = "/phonemanagements/lock",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Phonemanagement lock(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody LockCommand lockCommand
    ) throws Exception {
        System.out.println("##### /phonemanagement/lock  called #####");
        Phonemanagement phonemanagement = new Phonemanagement();
        phonemanagement.lock(lockCommand);
        phonemanagementRepository.save(phonemanagement);
        return phonemanagement;
    }

    @RequestMapping(
        value = "/phonemanagements/stoptheservice",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Phonemanagement stoptheservice(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody StoptheserviceCommand stoptheserviceCommand
    ) throws Exception {
        System.out.println(
            "##### /phonemanagement/stoptheservice  called #####"
        );
        Phonemanagement phonemanagement = new Phonemanagement();
        phonemanagement.stoptheservice(stoptheserviceCommand);
        phonemanagementRepository.save(phonemanagement);
        return phonemanagement;
    }

    @RequestMapping(
        value = "/phonemanagements/unlock",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Phonemanagement unlock(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UnlockCommand unlockCommand
    ) throws Exception {
        System.out.println("##### /phonemanagement/unlock  called #####");
        Phonemanagement phonemanagement = new Phonemanagement();
        phonemanagement.unlock(unlockCommand);
        phonemanagementRepository.save(phonemanagement);
        return phonemanagement;
    }

    @RequestMapping(
        value = "/phonemanagements/starttheservice",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Phonemanagement starttheservice(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody StarttheserviceCommand starttheserviceCommand
    ) throws Exception {
        System.out.println(
            "##### /phonemanagement/starttheservice  called #####"
        );
        Phonemanagement phonemanagement = new Phonemanagement();
        phonemanagement.starttheservice(starttheserviceCommand);
        phonemanagementRepository.save(phonemanagement);
        return phonemanagement;
    }
}
//>>> Clean Arch / Inbound Adaptor
