package tw.com.fcb.mimosa.examples.gettingstarted;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplaceUserDto {
	//不可為空字串
    @NotBlank
	 String name;

}
