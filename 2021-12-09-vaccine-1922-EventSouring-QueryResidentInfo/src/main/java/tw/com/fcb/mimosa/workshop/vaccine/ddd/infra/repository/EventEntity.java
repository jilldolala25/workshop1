package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "EVENT_STORE")
public class EventEntity {
  @Id
  @GeneratedValue
  Long id;

  String eventType;
  LocalDateTime eventTime;
  Long aggregateId;

  //以下可以是JSON格式欄位
  String nhiNo;
  String phoneNo;

}
