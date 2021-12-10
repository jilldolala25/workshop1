package tw.com.fcb.mimosa.workshop.vaccine.ddd.rest;

import java.util.List;
import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

@Data
public class ResidentInfo {
  Long id;
  String nhiNo;
  String phoneNo;
  Long residentId;
}
