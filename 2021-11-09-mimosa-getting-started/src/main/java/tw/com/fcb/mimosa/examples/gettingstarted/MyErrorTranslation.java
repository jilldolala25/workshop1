package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.domain.t9n.Term;
import tw.com.fcb.mimosa.domain.t9n.Translated;
import tw.com.fcb.mimosa.domain.t9n.TranslationService;

//錯誤訊息翻譯
@Service
@RequiredArgsConstructor
public class MyErrorTranslation  implements TranslationService{
	final ErrMsgService ErMsgSvc;
	@Override
	public Optional<Translated> translate(@NonNull Term term) {
		// TODO Auto-generated method stub
//		if (term.getCode().equals("ERR1")) {
//			return Optional.of(
//					new MyTranslation(term.getCategory(),
//													term.getCode(),
//													"查無姓名"));
//		}
	   
	   return Optional.of(new MyTranslation(term.getCategory(), 
			                                                        term.getCode(), 
			                                                        ErMsgSvc.getMsgByCode(term.getCode()).getTranslation()));
	
//		return Optional.empty();
	}
         
	@Getter
	@RequiredArgsConstructor
	static class MyTranslation implements Translated{
	
		final String category;
		final String code;
		final String translation;
		
	}
}
