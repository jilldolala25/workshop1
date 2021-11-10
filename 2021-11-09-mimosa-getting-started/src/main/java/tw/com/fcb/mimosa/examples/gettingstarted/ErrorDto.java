package tw.com.fcb.mimosa.examples.gettingstarted;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ErrorDto {
    Long errid;
    String category;
	String code;
	String translation;
	 }
