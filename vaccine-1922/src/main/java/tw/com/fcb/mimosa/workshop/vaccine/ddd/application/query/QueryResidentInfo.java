package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.ResidentInfo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryResidentInfo {
  final AppointmentRepository repository;

  public List<ResidentInfo> getResidentsInfo() {
    return repository.findResidentsInfo();
  }

}
