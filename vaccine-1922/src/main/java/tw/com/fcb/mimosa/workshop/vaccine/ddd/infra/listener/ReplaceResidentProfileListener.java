package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.event.ResidentProfileReplaced;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.EventEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.EventRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ReplaceResidentProfileListener {
  final EventRepository repository;

  @EventListener
  public void onReplaceResidentProfile(ResidentProfileReplaced event) {
    var eventEntity = new EventEntity();
    eventEntity.setEventType(event.getClass().getSimpleName());
    eventEntity.setEventTime(LocalDateTime.now());
    eventEntity.setAggregateId(event.getResidentId());
    eventEntity.setPhoneNo(event.getPhoneNo());

    repository.save(eventEntity);
  }
}
