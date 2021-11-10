package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.http.APIError;
import tw.com.fcb.mimosa.http.APIErrorException;
import tw.com.fcb.mimosa.http.APIErrorT9nException;
import tw.com.fcb.mimosa.tracing.Traced;
//@AllArgsConstructor
@Traced
@RequiredArgsConstructor
@Service
public class UserService {
	// 調用別的class
     //@Autowired
     final UserRepository repository;
     final UserDtoMapper mapper;
//     final ErrorRepository errorreposity;
     
//      public UserService(UserRepository repository) {
//    	  this.repository = repository;
//      }
     
     public User getByName(String name) {
    	 return repository.findByName(name)
    			 .orElseThrow(() -> {
//    				 return new APIErrorException(err -> err.code("ERR1").message("name not found"));
    				 return new APIErrorT9nException(err -> err.term(MyErrorCode.NAME_NOT_FOUND));


    			 });
     }
     //get
     public Collection<User> getUsers(){
    	 return repository.findAll();
     }
     //post
     public User createUser(CreateUserDto user) {
    	 return repository.save(mapper.createUser(user));
     }
     //modify
     public User replaceUser(long id, ReplaceUserDto user) {

    	 return repository.findById(id).map(db -> {
    		mapper.copyUser(user, db);
    		 return db;
    	 }).map(repository::save)
    	          .orElseThrow(() -> new IllegalArgumentException("id [" + id + "] not exist"));
     }
     
     
     public void delete (long id) {
    	 repository.deleteById(id);
     }
}
