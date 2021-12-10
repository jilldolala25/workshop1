package tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.event;

import lombok.Data;

@Data
public class AppointmentMade {
  Long residentId;
  String nhiNo;
  String phoneNO;

}
