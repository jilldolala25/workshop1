package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.MakeAppointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ReplaceResident;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Appointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentInfoEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentProfileEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.*;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.ResidentInfo;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ResidentAssembler {

  MakeAppointment toMakeAppointmentCommand(MakeAppointmentRequest request);

  ChooseVaccine toChooseVaccineCommand(ChooseVaccineRequest request);

  ResidentEntity toEntity(Appointment domain);

  CancelVaccine toCancelVaccineCommand(CancelVaccineRequest request);

  ReplaceResident toReplaceResidentCommand(ReplaceResidentRequest request);

  Appointment fromEntity(ResidentEntity residentEntity);

  // update 時不要把id 蓋掉，要ignore id　欄位不可蓋掉
  @Mapping(target = "id", ignore = true)
  ResidentProfileEntity copyProfileEntity(ResidentEntity resident,
      @MappingTarget ResidentProfileEntity profile);

  //把資料用逗號分隔
  default String toChooseString(List<ChooseEntity> chooses) {
    return chooses.stream().map(ChooseEntity::getVaccine)
        .map(Vaccine::name)
        .collect(Collectors.joining(","));
  }

  @Mapping(target = "residentId", source = "id")
  ResidentProfileEntity toProfileEntity(ResidentEntity resident);

  ResidentProfile toProfile(ResidentProfileEntity residentProfileEntity);

  ResidentInfo toInfo(ResidentInfoEntity residentInfoEntity);

  default List<Vaccine> fromChooseString(String choose) {
    return Arrays.stream(choose.split(","))
        .map(Vaccine::valueOf)
        .collect(Collectors.toList());
  }
}
