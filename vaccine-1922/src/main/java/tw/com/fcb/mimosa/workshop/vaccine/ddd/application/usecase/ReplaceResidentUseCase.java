package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tw.com.fcb.mimosa.ext.ddd.application.ApplicationUseCase;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.assembler.CommandAssembler;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ReplaceResident;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.event.AppointmentMade;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.event.ResidentProfileReplaced;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor

public class ReplaceResidentUseCase implements ApplicationUseCase<ReplaceResident, Void> {
  final AppointmentRepository repository;
  final CommandAssembler assembler;

  final ApplicationEventPublisher publisher;

  @Override
  public Void execute(@NotNull @Valid ReplaceResident command) {
    var domain = repository.findById(command.getId());
    if (StringUtils.hasText(command.getPhoneNo()) && domain.getNhiNo().equals(command.getNhiNo())) {
      domain.setPhoneNo(command.getPhoneNo());
      repository.save(domain);
      //20211209 發佈事件 eventsouring
      var event = new ResidentProfileReplaced();
      event.setResidentId(domain.getId());
      event.setPhoneNo(domain.getPhoneNo());
      publisher.publishEvent(event);
    }
    return null;
  }

}
