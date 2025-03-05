package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AlarmRepository alarmRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reported'"
    )
    public void wheneverReported_AlarmTheLost(@Payload Reported reported) {
        Reported event = reported;
        System.out.println(
            "\n\n##### listener AlarmTheLost : " + reported + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheLost(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reportcancelled'"
    )
    public void wheneverReportcancelled_AlarmTheLost(
        @Payload Reportcancelled reportcancelled
    ) {
        Reportcancelled event = reportcancelled;
        System.out.println(
            "\n\n##### listener AlarmTheLost : " + reportcancelled + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheLost(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Insurancecharged'"
    )
    public void wheneverInsurancecharged_AlarmTheInsurance(
        @Payload Insurancecharged insurancecharged
    ) {
        Insurancecharged event = insurancecharged;
        System.out.println(
            "\n\n##### listener AlarmTheInsurance : " +
            insurancecharged +
            "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheInsurance(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Servicestopped'"
    )
    public void wheneverServicestopped_AlarmTheStop(
        @Payload Servicestopped servicestopped
    ) {
        Servicestopped event = servicestopped;
        System.out.println(
            "\n\n##### listener AlarmTheStop : " + servicestopped + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheStop(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Servicestarted'"
    )
    public void wheneverServicestarted_AlarmTheStop(
        @Payload Servicestarted servicestarted
    ) {
        Servicestarted event = servicestarted;
        System.out.println(
            "\n\n##### listener AlarmTheStop : " + servicestarted + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheStop(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Locked'"
    )
    public void wheneverLocked_AlarmTheLock(@Payload Locked locked) {
        Locked event = locked;
        System.out.println(
            "\n\n##### listener AlarmTheLock : " + locked + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheLock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Unlocked'"
    )
    public void wheneverUnlocked_AlarmTheLock(@Payload Unlocked unlocked) {
        Unlocked event = unlocked;
        System.out.println(
            "\n\n##### listener AlarmTheLock : " + unlocked + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmTheLock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
