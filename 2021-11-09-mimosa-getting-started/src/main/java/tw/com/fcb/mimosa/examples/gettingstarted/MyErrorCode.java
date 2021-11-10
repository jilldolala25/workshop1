package tw.com.fcb.mimosa.examples.gettingstarted;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.domain.t9n.Term;
@Getter
@RequiredArgsConstructor
public enum MyErrorCode implements Term {
	   //情境1
      NAME_NOT_FOUND("SAMPLE_CATEGORY","ERR1"),
	  ID_NOT_FOUND("SAMPLE_CATEGORY","ERR2"), 
	  ;
	
	  final String category;
	  final String code;
}
