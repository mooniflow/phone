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
   
        Alarm alarm = new Alarm();
        alarm.setUserId(reported.getUserId());
        alarm.setPhoneId(reported.getPhoneId());
        alarm.setType("locked");
        alarm.setDescription("Alarm for the reported lost!");
        repository().save(alarm);
        
        

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
        Alarm alarm = new Alarm();
        alarm.setUserId(reportcancelled.getUserId());
        alarm.setPhoneId(reportcancelled.getPhoneId());
        alarm.setType("unlocked");
        alarm.setDescription("Alarm for the cancelled lost!");
        repository().save(alarm);

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
        Alarm alarm = new Alarm();
        alarm.setUserId(insurancecharged.getUserId());
        alarm.setPhoneId(insurancecharged.getPhoneId());
        alarm.setType("insurance");
        alarm.setDescription("Alarm for insurance!");
        repository().save(alarm);

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
        Alarm alarm = new Alarm();
        alarm.setUserId(servicestopped.getUserId());
        alarm.setPhoneId(servicestopped.getPhoneId());
        alarm.setType(servicestopped.getService());
        alarm.setDescription("Alarm for stopped service!");
        repository().save(alarm);

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
        Alarm alarm = new Alarm();
        alarm.setUserId(servicestarted.getUserId());
        alarm.setPhoneId(servicestarted.getPhoneId());
        alarm.setType(servicestarted.getService());
        alarm.setDescription("Alarm for restarting service!");
        repository().save(alarm);

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

        
        Alarm alarm = new Alarm();
        alarm.setUserId(locked.getUserId());
        alarm.setPhoneId(locked.getPhoneId());
        alarm.setType(locked.getLock());
        alarm.setDescription("Alarm for locked phone!");
        repository().save(alarm);

        

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
        Alarm alarm = new Alarm();
        alarm.setUserId(unlocked.getUserId());
        alarm.setPhoneId(unlocked.getPhoneId());
        alarm.setType(unlocked.getLock());
        alarm.setDescription("Alarm for unlocked phone!");
        repository().save(alarm);
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
