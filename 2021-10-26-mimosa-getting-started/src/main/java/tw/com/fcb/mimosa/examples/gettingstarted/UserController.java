package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// API的入口
@RequestMapping("/users")
public class UserController {
	
	static List<User> userList = new ArrayList<User>();
	@Autowired
	UserDtoMapper mapper;
	
	@GetMapping
	List<UserDto> getUser() {
//		User user = new User();
//		user.setName("HanRu");
//		user.setAge(18);
//		return user;
//		return  User.builder()
//				.age(17)
//				.name("HanRu")
//				.build();
		List<UserDto> dtos = new ArrayList<>();
		for (User user : userList) {
//			UserDto dto = UserDto.builder().
//					name(user.getName()) //BeanUtils.copyProertities();
//					.build();
			UserDto dto = mapper.from(user);
			dtos.add(dto);
		}
//		List<UserDto> java8dto = new ArrayList<>();
//		users.stream().map(user -> UserDto.builder().name(user.getName()).build())
//		.collect(Collectors.toList());
		
		return dtos;
	}
	@PostMapping
	void createUser(@RequestBody User user){
		
		userList.add(user);
	}
	
	// repository : 2021-10-26 放上GitHub Public
	
	//要過濾要修改及刪除的資料
	//modify user
	//@PutMapping
	
	
	//要再加檢核不可更改key值
	@PutMapping
	void modifyUser(@RequestBody User user){
		for (User usr:userList) {
			int i = 0;
			if (usr.getId()==(user.getId())) {
				User updateuser = User.builder().name(user.getName()).age(user.getAge()).id(user.getId()).build();
				userList.set(i, updateuser);   	
			}
			i++;
		}
	}
	
	
	
	//delete user
	//刪除前端可只傳key值就可以刪除嗎??
	@DeleteMapping
      void deleteUser(@RequestBody User user){
		
		for (User usr:userList) {
			if (usr.getId()==(user.getId()))  {
				userList.remove(user);
			}
		}
		
	}
}
