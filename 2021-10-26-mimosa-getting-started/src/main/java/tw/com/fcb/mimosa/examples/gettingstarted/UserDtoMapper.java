package tw.com.fcb.mimosa.examples.gettingstarted;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserDtoMapper {
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "userName")
	@Mapping(source = "age", target = "age")
	UserDto from(User user);
}
