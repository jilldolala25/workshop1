package tw.com.fcb.mimosa.workshop.vaccine.ddd.rest;

import lombok.Data;

import javax.persistence.Id;

@Data
public class ReplaceResidentRequest {

  String nhiNo;
  String phoneNo;

}
