package tw.com.fcb.mimosa.examples.gettingstarted;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.http.APIErrorException;
import tw.com.fcb.mimosa.http.APIErrorT9nException;
import tw.com.fcb.mimosa.tracing.Traced;

@Traced
@RequiredArgsConstructor
@Service
public class ErrMsgService {
	final ErrorRepository errMsgRepository;
	final ErrorDtoMapper errmapper;
	public ErrorMsg getMsgByCode(String code) {
		
   	 return errMsgRepository.findByCode(code)
   			 .orElseThrow(() -> {
   				 return new APIErrorException(err -> err.code("ERR").message("no"));
   				 


   			 });
    }


	
	 //post
    public ErrorMsg createErrMsg(CreateErrorDto code) {
   	 return errMsgRepository.save(errmapper.createError(code));
   	
    }
    

}
