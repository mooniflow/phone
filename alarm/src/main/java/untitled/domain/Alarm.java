package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AlarmApplication;

@Entity
@Table(name = "Alarm_table")
@Data
//<<< DDD / Aggregate Root
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long phoneId;

    private String type;

    private String description;

    public static AlarmRepository repository() {
        AlarmRepository alarmRepository = AlarmApplication.applicationContext.getBean(
            AlarmRepository.class
        );
        return alarmRepository;
    }

    //<<< Clean Arch / Port Method
    public static void alarmTheLost(Reported reported) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(reported.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmTheLost(Reportcancelled reportcancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(reportcancelled.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmTheInsurance(Insurancecharged insurancecharged) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(insurancecharged.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmTheStop(Servicestopped servicestopped) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(servicestopped.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmTheStop(Servicestarted servicestarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(servicestarted.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmTheLock(Locked locked) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(locked.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmTheLock(Unlocked unlocked) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(unlocked.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
