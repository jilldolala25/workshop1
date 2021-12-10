package tw.com.fcb.mimosa.workshop.vaccine.ddd.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentInfoRepository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.ResidentInfo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryResidentInfo {
  final AppointmentRepository repository;

  public List<ResidentInfo> getResidentsInfo() {
    return repository.findResidentsInfo();
  }



}
