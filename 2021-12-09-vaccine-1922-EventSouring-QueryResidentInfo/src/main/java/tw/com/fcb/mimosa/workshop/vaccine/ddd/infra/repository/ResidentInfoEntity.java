package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RESIDENT_INFO")
public class ResidentInfoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  Long residentId;
  String nhiNo;
  String phoneNo;
}
