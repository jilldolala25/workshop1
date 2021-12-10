package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.listener;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.event.AppointmentMade;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.EventEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.EventRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MakeAppointmentListener {
  final EventRepository repository;

  @EventListener
  public void onAppointmentMade(AppointmentMade event) {
    var eventEntity = new EventEntity();
    eventEntity.setEventType(event.getClass().getSimpleName());
    eventEntity.setEventTime(LocalDateTime.now());
    eventEntity.setAggregateId(event.getResidentId());
    eventEntity.setPhoneNo(event.getPhoneNO());
    eventEntity.setNhiNo(event.getNhiNo());
    repository.save(eventEntity);
  }
}
