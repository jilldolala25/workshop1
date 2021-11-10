package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.http.APIErrorT9nException;
import tw.com.fcb.mimosa.http.APIRequest;
import tw.com.fcb.mimosa.http.APIResponse;
import tw.com.fcb.mimosa.tracing.Traced;
@Traced
@Validated
@RequiredArgsConstructor
@RestController
// API的入口
@RequestMapping("/users")
public class UserController {
	
	static List<User> userList = new ArrayList<User>();
	//@Autowired
	final UserDtoMapper mapper;
	final UserService service;
	final ErrMsgService errservice;
	@PostMapping("/names")
	APIResponse<User> getByName(@RequestBody APIRequest<String>name) {
		return APIResponse.success(service.getByName(name.getBody()));
	}

	
	
	@GetMapping
	APIResponse<List<UserDto>> getUser() {
		//方法１
		//service.getUsers().stream().map(user -> mapper.from(user)).collect(Collectors.toList());
		
		List<UserDto> found = service.getUsers().stream().map(mapper::from).collect(Collectors.toList());
		if (found.isEmpty()) {
			//方法2
			 //throw new APIErrorT9nException(err -> err.term(MyErrorCode.ID_NOT_FOUND));
			//方法3
			//return APIResponse.error(err -> err.code("").message(""));
		}
		return APIResponse.success(found);

	}
	@PostMapping
	APIResponse<Long> createUser(@Validated @RequestBody APIRequest<CreateUserDto> user){
//		
//		userList.add(user);
// 把id吐回去
		return APIResponse.success( service.createUser(user.getBody()))
				.map(User::getId);
	}
	
	@PostMapping("/error")
	APIResponse<Long> createError(@Validated @RequestBody APIRequest<CreateErrorDto> code){
//		
//		userList.add(user);
// 把id吐回去
		return APIResponse.success( errservice.createErrMsg(code.getBody()))
				.map(ErrorMsg::getId);
	}
	
	@PutMapping("/{id}")
	// @Min(0)檢核輸入的id不得小於0
	void modifyUser(@Min(0) @PathVariable("id") Long id, @Validated @RequestBody ReplaceUserDto user) {

	   service.replaceUser(id,user);
	}

	
	
	
	//delete user
	@DeleteMapping("/{id}")
	void deleteUser(@Min(0) @PathVariable("id") Long  id) {
		service.delete(id);
	}

}