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
import untitled.domain.Locked;
import untitled.domain.Servicestarted;
import untitled.domain.Servicestopped;
import untitled.domain.Unlocked;

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

    @PostPersist
    public void onPostPersist() {
        Locked locked = new Locked(this);
        locked.publishAfterCommit();

        Servicestopped servicestopped = new Servicestopped(this);
        servicestopped.publishAfterCommit();

        Insurancecharged insurancecharged = new Insurancecharged(this);
        insurancecharged.publishAfterCommit();

        Unlocked unlocked = new Unlocked(this);
        unlocked.publishAfterCommit();

        Servicestarted servicestarted = new Servicestarted(this);
        servicestarted.publishAfterCommit();
    }

    public static PhonemanagementRepository repository() {
        PhonemanagementRepository phonemanagementRepository = PhonemanagementApplication.applicationContext.getBean(
            PhonemanagementRepository.class
        );
        return phonemanagementRepository;
    }

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
