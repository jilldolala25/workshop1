package tw.com.fcb.mimosa.examples.gettingstarted;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface ErrorDtoMapper {
	
	ErrorDto from(ErrorMsg error);
	
	ErrorMsg createError(CreateErrorDto errdto);
	
}
