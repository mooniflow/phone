package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.PhonemanagementApplication;
import untitled.domain.Insurancecharged;

@Entity
@Table(name = "Phonemanagement_table")
@Data
//<<< DDD / Aggregate Root
public class Phonemanagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long phoneId;

    private Long userId;

    private String status;

    private String lock;

    private String service;

    public static PhonemanagementRepository repository() {
        PhonemanagementRepository phonemanagementRepository = PhonemanagementApplication.applicationContext.getBean(
            PhonemanagementRepository.class
        );
        return phonemanagementRepository;
    }

    //<<< Clean Arch / Port Method
    public void lock(LockCommand lockCommand) {
        //implement business logic here:
        this.setPhoneId(lockCommand.getPhoneId());
        this.setUserId(lockCommand.getUserId());
        this.setLock(lockCommand.getLock());

        Locked locked = new Locked(this);
        locked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void stoptheservice(StoptheserviceCommand stoptheserviceCommand) {
        //implement business logic here:

        Servicestopped servicestopped = new Servicestopped(this);
        servicestopped.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void unlock(UnlockCommand unlockCommand) {
        //implement business logic here:

        Unlocked unlocked = new Unlocked(this);
        unlocked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void starttheservice(StarttheserviceCommand starttheserviceCommand) {
        //implement business logic here:

        Servicestarted servicestarted = new Servicestarted(this);
        servicestarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void callInsurance(Insurancecalled insurancecalled) {
        //implement business logic here:

        /** Example 1:  new item 
        Phonemanagement phonemanagement = new Phonemanagement();
        repository().save(phonemanagement);

        Insurancecharged insurancecharged = new Insurancecharged(phonemanagement);
        insurancecharged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(insurancecalled.get???()).ifPresent(phonemanagement->{
            
            phonemanagement // do something
            repository().save(phonemanagement);

            Insurancecharged insurancecharged = new Insurancecharged(phonemanagement);
            insurancecharged.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
