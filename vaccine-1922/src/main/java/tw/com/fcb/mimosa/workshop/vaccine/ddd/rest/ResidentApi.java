package tw.com.fcb.mimosa.workshop.vaccine.ddd.rest;

import org.springframework.web.bind.annotation.*;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.ResidentInfo;

import java.util.List;

@RequestMapping("/residents")
public interface ResidentApi {

  @PostMapping
  long makeAppointment(
      @RequestBody MakeAppointmentRequest request);

  @PutMapping("/{id}/")
  void replaceResident(@PathVariable("id") long id,
      @RequestBody ReplaceResidentRequest request);

  @PutMapping("/{id}/vaccines")
  void chooseVaccine(@PathVariable("id") long id,
      @RequestBody ChooseVaccineRequest request);

  @DeleteMapping("/{id}/vaccines")
  void cancelVaccine(@PathVariable("id") long id,
      @RequestBody CancelVaccineRequest request);

  @GetMapping
  List<ResidentProfile> getResidents();

  @GetMapping("resident-info")
  List<ResidentInfo> getResidentsInfo();
}
